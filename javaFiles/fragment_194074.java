Cookie[] cookies = request.getCookies();
if (cookies != null) {
    boolean bool = Arrays.stream(cookies)
                         .filter(cookie -> 
                            (cookie.getName().equals("_id") ? 
                              isIdCookieValid(cookie, auth) : 
                              cookie.getName().equals("XSRF-TOKEN") && 
                                isXSRFTokenValid(cookie, request)))
                         .count() == 2;

    System.out.println(bool ? "Ok" : "")
}