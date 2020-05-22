Cookie cookies[] = request.getCookies();
if (cookies != null) {

    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("_id")) {
            boolean bool_1 = isIdCookieValid(cookie, auth);
        }
        else if (cookie.getName().equals("XSRF-TOKEN")) {
            boolean bool_2 = isXSRFTokenValid(cookie, request);
        }
    }

    if (bool_1 && bool_2) {
        System.out.println("Ok");
    }
    // else if they are not both true do nothing
}