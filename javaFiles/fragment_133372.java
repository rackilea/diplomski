public static void main(String[] args) {
    WebClient webClient = new WebClient();
    try {
        HtmlPage page = (HtmlPage) webClient
                .getPage("https://ma-andover.myfollett.com/aspen/logon.do");
        HtmlForm form = page.getFormByName("logonForm");
        form.getInputByName("username").setValueAttribute("myUsername"); 
        HtmlInput passWordInput = form.getInputByName("password");
        passWordInput.removeAttribute("disabled");
        passWordInput.setValueAttribute("myPassword"); 

        page = form.getInputByValue("Log On").click(); // works fine

        System.out.println(page.asText());
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        webClient.close();
    }
}