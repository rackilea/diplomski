public ModelAndView authenficateUser(HttpServletRequest request,
                               HttpServletResponse response,
                               @RequestParam String email) {
    User u = _userDao.getByEmail(email);
    if (u == null) {
        // deal with unknown user and return to login form
    } else {
        request.getSession().setAttribute("email", email);
        // success
    }
}