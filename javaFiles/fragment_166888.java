public ModelAndView postLoginPage(@ModelAttribute("user") User user, ModelMap model,
                                      HttpServletRequest req, HttpServletResponse res) {

    if (user != null) {
        logger.log(Level.INFO, "\n\n [*][*][*][*][*] user not null ");
        if (user.getUsername().equals("jon")){
            return new ModelAndView("echo", "user", user);
        }
    } else { 
        return new ModelAndView("oops", "user", user);       
    }
    return null;
}