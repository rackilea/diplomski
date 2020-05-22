public static void main(String[] args) throws IOException {
    String url = "https://auto.ru/cars/new/group/mercedes/e_klasse/20743577/20886691/?grouping_id=tech_param_id%3D20743577%2Ccomplectation_id%3D21225392&sort=fresh_relevance_1-desc&geo_radius=200";

    try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60)) {
        webClient.getOptions().setThrowExceptionOnScriptError(false);

        HtmlPage page = webClient.getPage(url);

        HtmlElement clickContact = (HtmlElement) page.getElementById("confirm-button");
        page = clickContact.click();
        System.out.println("still running " + webClient.waitForBackgroundJavaScript(60_000));
        System.out.println(" ---- ");

        // the page content got changed via javascript
        // we like to get see the new content
        page = (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();
        System.out.println(page.asText());
    }
}