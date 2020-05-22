try {    
    String url = "http://www.interpals.net/login.php";
    String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.130 Safari/537.36";

    Connection.Response response = Jsoup.connect(url).userAgent(userAgent)
            .method(Connection.Method.GET)
            .execute();

    response = Jsoup.connect(url)
            .cookies(response.cookies())
            .data("action", "login")
            .data("login", "login")
            .data("password", "password")
            .data("auto_login", "1")
            .userAgent(userAgent)
            .method(Connection.Method.POST)
            .followRedirects(true)
            .execute();            

    Document doc = Jsoup.connect("http://www.interpals.net/friends.php")
            .cookies(response.cookies())
            .userAgent(userAgent)
            .get();

    System.out.println(doc);

} catch (IOException e) {
    e.printStackTrace();
}