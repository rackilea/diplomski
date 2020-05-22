public static void main(String[] args) throws IOException {

    java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);

    WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
    String url = "https://www.kinoheld.de/kino-muenchen/royal-filmpalast/vorstellung/280823/?mode=widget&showID=280828#panel-seats";

    webClient.getOptions().setUseInsecureSSL(true);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    webClient.waitForBackgroundJavaScript(9000);
    HtmlPage response = webClient.getPage(url);

    System.out.println(response.getTitleText());
}