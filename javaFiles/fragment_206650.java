//some other controller code
 @RequestMapping("/start")
 public ModelAndView start(....) {
       ModelAndView mav = new ModelAndView("example");
       mav.addObject("button_text", "START");

       return mav;
 }
 //...