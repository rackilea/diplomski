Connection.Response loginForm = Jsoup.connect(loginFormUrl)
         .method(Connection.Method.GET)
         .execute();

    Map<String, String> loginCookies = loginForm.cookies();

    Document document = Jsoup
        .connect(loginFormUrl)
        .data("akcio", akcio)
        .data("felnev",felnev)
        .data("jelszo",jelszo)
        .cookies(loginCookies)
        .post();

    Document document2 = Jsoup.connect(loggedInUrl)
    .cookies(loginCookies)
    .get();
    System.out.println(document2);