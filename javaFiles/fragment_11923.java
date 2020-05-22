public static void main(String[] args) throws Exception {

   Connection.Response loginForm = Jsoup.connect("http://webspace.apiit.lk/index.jsp")
        .timeout(0)  //0 means infinite
        .method(Connection.Method.GET)
        .execute();

   Response res = Jsoup.connect("http://webspace.apiit.lk/index.jsp")
        .timeout(0)  //0 means infinite
        .data("UserID", "cb004277")
        .data("Password", " ")
        //.data("Submit", "Log In")
        .cookies(loginForm.cookies())
        .method(Method.POST)
        .execute();

   Map<String, String> cookies = res.cookies();

   Document doc = Jsoup.connect("http://webspace.apiit.lk/index.jsp").cookies(cookies).get();

   System.out.println(doc);
}