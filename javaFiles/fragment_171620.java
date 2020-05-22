@RequestMapping(value = "/pathtorequest", method = RequestMethod.POST)
    public ModelAndView redirectdemo( HttpServletRequest req,@ModelAttribute(value="demo") Employee e, ModelMap modelMap) {
     for(String s : modelMap.keySet()){
        System.out.println("key::"+s+" value::"+modelMap.get(s));
     }
    }