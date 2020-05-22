WebClient webClient = new WebClient();
try {
    HtmlPage page = (HtmlPage) webClient.getPage("https://uk.advfn.com/forum/search?q=login&index=posts&post_poster=on");
    HtmlForm form = page.getFormByName("login_form");
    form.getInputByName("login_username").setValueAttribute("yourusername");
    HtmlInput passWordInput = form.getInputByName("login_password");
    passWordInput.removeAttribute("disabled");
    passWordInput.setValueAttribute("yourpassword");

    page = form.getInputByValue("Log In").click(); 

    System.out.println(page.asText());
} catch (Exception e) {
    e.printStackTrace();
} finally {
    webClient.close();
}