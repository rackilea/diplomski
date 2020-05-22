HttpServletResponse resp

Cookie[] cookies = request.getCookies();    

Cookie the_cookie // get the good one !

the_cookie.setMaxAge(0);

resp.addCookie(the_cookie);