@Test
public void homePage_proxy() throws Exception {
    final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_2, "http://myproxyserver", myProxyPort);

    //set proxy username and password 
    final DefaultCredentialsProvider credentialsProvider = (DefaultCredentialsProvider) webClient.getCredentialsProvider();
    credentialsProvider.addProxyCredentials("username", "password");

    final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
    assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());

    webClient.closeAllWindows();
}