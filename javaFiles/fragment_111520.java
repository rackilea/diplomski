Connection.Response res = Jsoup.connect("http://www.example.com/login.php")
    .data("username", "myUsername", "password", "myPassword")
    .method(Method.POST)
    .execute();

Document doc = res.parse();
String sessionId = res.cookie("SESSIONID"); // you will need to check what the right cookie name is