@RequestMapping(value = "/foo", method = RequestMethod.GET)
public ModelAndView ReadFoobar(Locale locale, 
                               Model model, 
                               HttpServletRequest request){
    String foobar = getService().loadFoobar();
    ModelAndView mav = new ModelAndView("foobarPage")
    mav.addObject("foobar",foobar);
    return mav;
}

@RequestMapping(value = "/foo", method = RequestMethod.POST)
public String InsertStuff(@RequestParam("stuff") String stuff,
                          Locale loc, 
                          Model model,
                          HttpServletRequest req){
    validate();
    getService().insertStuff(stuff);
    return "stuffPage";
}