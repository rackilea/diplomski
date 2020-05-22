// logging in
    System.out.println("logging in...");
    Response res = Jsoup.connect("https://ww2.yggtorrent.is/user/login")
            .timeout(10000)
            .data("id", "<MyLogin>", "pass", "<MyPassword>")
            .method(Method.POST)
            .execute();

    // getting cookies from response
    Map<String, String> cookies = res.cookies();
    System.out.println("got cookies: " + cookies);

    // optional verification if logged in
    System.out.println(Jsoup.connect("https://ww2.yggtorrent.is").cookies(cookies).get()
            .select("#panel-btn").first().text());

    // connecting with cookies, it may be useful to provide referer as some servers expect it
    Response resultImageResponse = Jsoup.connect("https://ww2.yggtorrent.is/engine/download_torrent?id=285633")
            .referrer("https://ww2.yggtorrent.is/engine/download_torrent?id=285633")
            .cookies(cookies)
            .ignoreContentType(true)
            .execute();

    // saving file
    FileOutputStream out = (new FileOutputStream(new java.io.File("C:/toto.torrent")));
    out.write(resultImageResponse.bodyAsBytes());
    out.close();
    System.out.println("done");