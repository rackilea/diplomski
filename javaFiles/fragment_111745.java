Connection.Response initialPage = Jsoup.connect("https://www.flightview.com/flighttracker/")
            .headers(headers)
            .method(Connection.Method.GET)
            .userAgent(userAgent)
            .execute();
    Map<String, String> initialCookies = initialPage.cookies();