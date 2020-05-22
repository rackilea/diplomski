Connection.Response initialResponse = null;
    try {
        // get "lt" and "execution" value
        initialResponse = = Jsoup.connect("http://pawscas.usask.ca/cas-web/login").method(Method.GET).execute();
        Document doc = initialResponse.parse();

        // get lt
        Element lt = doc.select("input[name=lt]").first();
        String ltVal = lt.attr("value");

        // get execution
        Element execution = doc.select("input[name=execution]").first();
        String executionVal = execution.attr("value");

        // get cookies
        Map<String, String> cookies = initialResponse.cookies();

        // now do the login
        res = Jsoup.connect("http://pawscas.usask.ca/cas-web/login")
            .data("username", "user") 
            .data("password", "pass")
            .data("lt", ltVal)
            .data("execution", executionVal)
            .data("_eventId", "submit")
            .cookies(cookies)
            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36")
            .method(Method.POST)
            .execute();
    } catch (IOException e) {
        e.printStackTrace();
    }

     //System.out.println(res.cookies());

    cookies.putAll(res.cookies());

    Document doc = null;
    try {
        doc = Jsoup.connect("https://paws5.usask.ca/web/home-community#mycourses")
          .cookies(cookies)
          .get();
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println(doc.toString());