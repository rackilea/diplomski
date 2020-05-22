@RequestMapping(value="display-searched-user",method={RequestMethod.GET,RequestMethod.POST})
public ModelAndView displayResultUser (HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("result");

    User user;
    if(UserTransporter.isUserAvailable()) user = UserTransporter.getUser();
    else return "ERROR, no user available to display";

    //do something with the obtained user object

    return mav;
}