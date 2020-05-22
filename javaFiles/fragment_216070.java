@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
public String logoutDo(HttpServletRequest request,HttpServletResponse response){
HttpSession session= request.getSession(false);
    SecurityContextHolder.clearContext();
         session= request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        for(Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }

    return "logout";
}