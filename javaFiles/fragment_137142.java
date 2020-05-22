String encodedUrl = "http://xyo.net/iphone-app/instagram-RrkBUFE/";

    Response res = Jsoup.connect(encodedUrl)
            .header("Accept-Language", "en")
            .ignoreHttpErrors(true)
            .ignoreContentType(true)
            .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .followRedirects(true)
            .timeout(10000)
            .method(Connection.Method.GET)
            .execute();


    System.out.println(res.parse());