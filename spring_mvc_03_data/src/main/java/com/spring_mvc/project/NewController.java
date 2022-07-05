package com.spring_mvc.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {
	
	@RequestMapping("/")
	public String index() {
		return "index";	// 뷰페이지 이름 반환 : index.jsp
	}
	
	// 뷰 페이지로 데이터 전달
	// 'showInfo' 요청이 들어오면
	// Model 객체를 이용하여 데이터 설정 : key(이름)은 'name', value(값)은 "홍길동"
	// 뷰 페이지를'showInfo' 뷰 페이지로 객체 전달 됨
	
	@RequestMapping("/showInfo")
	public String showInfo(Model model) {
		model.addAttribute("name","홍길동");
		model.addAttribute("age",30);
		return "showInfo"; // 뷰 페이지 이름 반환 : showInfo.jsp
	}
	
	// ModelAndView 사용 : 데이터와 뷰 이름 둘 다 설정
	
	@RequestMapping("/showInfo2")
	public ModelAndView showInfo2(ModelAndView mv) {
		mv.addObject("name", "이몽룡"); // 데이터 설정
		mv.addObject("address", "서울"); // 데이터 설정
		mv.setViewName("showInfo2"); // 뷰 이름 설정
		return mv; // ModelAndView 객체 반환
	}
	
	@RequestMapping("/showInfo3")
	public ModelAndView showInfo3(Model model, ModelAndView mv) {
		model.addAttribute("name","이몽룡");
		
		//mv.addObject("name","성춘향"); //ModelAndView가 우선
		mv.addObject("age",25);
		mv.setViewName("showInfo3");
		
		model.addAttribute("address","남원");
		return mv; //ModelAndView 객체 반환
		
		
	}
}
