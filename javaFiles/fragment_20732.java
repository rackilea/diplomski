@RequestMapping(value="display-searched-user",method={RequestMethod.GET,RequestMethod.POST})
public ModelAndView displayResultUser (HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("result");

    FirstController fc = new FirstController();
    return fc.searchUser(request);
}