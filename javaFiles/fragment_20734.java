@RequestMapping(value="search-user",method=RequestMethod.POST)
public ModelAndView searchUser (HttpServletRequest request) {
    //Retrieve the search query by request.getParameter
    String searchQuery = request.getParameter("searchQuery");

    //Search for the user (this is the object that I want to pass)
    User user = userDao.searchUser(searchQuery);

    ModelAndView mav = new ModelAndView(new RedirectView("display-searched-user"));
    mav.addObject("user",user);

    UserTransporter.setUser(user);

    return mav;
}