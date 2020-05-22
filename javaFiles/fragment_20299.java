@RequestMapping(value = "/Home", method = RequestMethod.GET)
public ModelAndView getHome(){
  //view name append with .jsp
  return new ModelAndView("myHome"); 
}

@RequestMapping(value = "/FormA", method = RequestMethod.POST)
public String postFormA(Email Email, Model model){
  //do stuff then
  //redirect to different requestMapping broswer url "/Home"
  return "redirect:/Home";
}

@RequestMapping(value = "/FormB", method = RequestMethod.POST)
public String postFormB( Model model){
  //do stuff then
  //redirect to different requestMapping and display in broswer url "/Home"
  return "redirect:/Home";
}