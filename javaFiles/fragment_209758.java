String url = "http://example.org/";
Document doc = Jsoup.connect(url).get();

URI uri = new URI(url);
Elements images = doc.select("ul.bjqs > li > img");
for (Element e : images) {
    String relative = e.attr("src");
    System.out.println(uri.resolve(relative));
}