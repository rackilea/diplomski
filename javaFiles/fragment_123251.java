String url = "https://en.wikipedia.org/w/api.php?action=query&titles=Main%20Page&prop=revisions&rvprop=content&format=jsonfm ";
    org.jsoup.nodes.Document document = (org.jsoup.nodes.Document) Jsoup
            .connect(url).followRedirects(false).timeout(60000).get();
    org.jsoup.select.Elements elements = ((org.jsoup.nodes.Document) document)
            .body().children();
for (Element element : elements) {
    System.out.println(element);
}