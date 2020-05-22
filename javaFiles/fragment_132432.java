@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
public String logout(HttpServletRequest request, SessionStatus session){
    session.setComplete();
    request.getSession().invalidate();
    return "login";
}