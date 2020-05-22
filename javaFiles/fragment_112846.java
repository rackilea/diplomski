try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
    String url = "https://www.epam.com/careers/job-listings?query=java&department=all&city=Kyiv&country=Ukraine";

    HtmlPage page = webClient.getPage(url);
    Thread.sleep(3_000);
    System.out.println(page.asXml());
}