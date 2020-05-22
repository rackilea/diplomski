try {
    Response loginForm = Jsoup.connect("http://sac.desktop.com.br/Cliente_Login.jsp")
        .method(Method.GET)
        .execute();

    Response login = Jsoup.connect("http://sac.desktop.com.br/Cliente_Menu.jsp")
        .data("acao", "entrar")
        .data("num", "user")
        .data("senha", "password")
        .cookies(loginForm.cookies())
        .method(Method.POST)
        .execute();

    Document page = Jsoup.connect("http://sac.desktop.com.br/Cliente_Menu.jsp")
        .cookies(loginForm.cookies())
        .get();

    System.out.println(page.html());
} catch (IOException e) {
    e.printStackTrace();
}