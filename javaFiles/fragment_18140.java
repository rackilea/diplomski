HtmlPage currentPage = (HtmlPage) webClient.getPage(newURL("http://www.animewallpapers.com"));
@SuppressWarnings("unchecked")
List<HtmlImage> urls = (List<HtmlImage>) currentPage.getByXPath("//img");
for(int i = 0; i < 500; i++){
    currentPage = (HtmlPage) webClient.getPage(new URL(urls.get(i).toString()));
    @SuppressWarnings("unchecked")
    List<HtmlImage> tempListUrls = (List<HtmlImage>) currentPage.getByXPath("//img");