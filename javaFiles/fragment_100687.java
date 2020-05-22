public static void main(String[] args) throws IOException {
    final String url = "https://www.nba.com/standings#/";

    try (final WebClient webClient = new WebClient()) {
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setUseInsecureSSL(true);

        HtmlPage page = webClient.getPage(url);
        webClient.waitForBackgroundJavaScript(10000);

        System.out.println(page.asXml());
    }
}