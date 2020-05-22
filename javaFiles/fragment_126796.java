@RequestMapping(value="/login.html", method=RequestMethod.GET)
public ModelAndView login(){   
    ModelAndView mv = new ModelAndView("login");
    if (numberOfLogins>5)
       mv.setViewName(new RedirectView("lockedAccount"));
    //ommited
    retun mv;
}