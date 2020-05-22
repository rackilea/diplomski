Connection.Response loginForm = Jsoup.connect("login page")
        .data("cookieexists", "false")
        .data("username", "user")
        .data("password", "pass")
        .data("loginbtn", "Log in")
        //.cookies(loginCookies)
        .method(Connection.Method.POST)
        .execute();

//here `loginForm` connected to server with your credentials
//and server returned response with cookies containing informations
//required to continue session so you should store them
//and reuse to access farther pages
Map<String, String> loginCookies  = loginForm.cookies();

Document document2 = Jsoup.connect("Page with access required")
        .cookies(loginCookies)
        .get();

System.out.println(document2);