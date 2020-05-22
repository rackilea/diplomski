@RequestMapping(value = "/hello")
public ModelAndView hello() {  
   ModelAndView mv = new ModelAndView();  
   mv.addObject("message", "Hello World!<br>"); 
   mv.addObject("title", "aaa"); 
   return mv;  
}