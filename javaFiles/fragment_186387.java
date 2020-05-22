try (WebClient webClient = new WebClient()) {
    HtmlPage page = webClient.getPage("http://localhost:8080");
    HtmlImageInput input = page.querySelector("input");
    URL url = page.getFullyQualifiedUrl(input.getSrcAttribute());
    final String accept = webClient.getBrowserVersion().getImgAcceptHeader();
    final WebRequest request = new WebRequest(url, accept);
    request.setAdditionalHeader("Referer", page.getUrl().toExternalForm());
    WebResponse imageWebResponse =  webClient.loadWebResponse(request);
}