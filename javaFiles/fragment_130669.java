Connection.Response loginForm = Jsoup
  .connect("http://www.gymnasiumleiden.nl/roostersinfoweb/infoweb/index.php")
  .method(Connection.Method.GET)
  .execute();

Document doc = loginForm.parse();
String csrf = doc.select("input[name=csrf]").val();
Connection.Response response = Jsoup.connect("http://www.gymnasiumleiden.nl/roostersinfoweb/infoweb/index.php")
        .data("user", "110638")
        .data("paswoord", "sgl1617")
        .data("login", "loginform")
        .data("csrf", csrf)
        .cookies(loginForm.cookies())
        .method(Connection.Method.POST)
        .execute();
String body = response.body();
if(body.contains("Wachtwoord is incorrect")){
    System.out.println("Password incorrect!");
} else if(body.contains("Gebruikersnaam werd niet gevonden.")){
    System.out.println("Not found username!");
} else {
    System.out.println("Login successfully!");          
}