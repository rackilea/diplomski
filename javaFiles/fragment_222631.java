if(remember_me_is_checked)
{
    Cookie c = new Cookie("userid", userId.toString());
    c.setMaxAge(24*60*60);
    response.addCookie(c);  // response is an instance of type HttpServletReponse
}