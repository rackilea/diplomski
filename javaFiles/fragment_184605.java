<%
for (Cookie cookie : request.getCookies()) {
    cookie.setValue("");
    cookie.setMaxAge(0);
    cookie.setPath("/");

    response.addCookie(cookie);
}
%>