String url = "https://en.wikipedia.org/wiki/Knowledge";
Document document = Jsoup.connect(url).timeout(6000).get();
Elements links = document.select("#bodyContent a[href^=\"/wiki/\"]");
for (Element e : links) {
    System.out.println(e.attr("href"));
}
System.out.println("Links found: " + links.size());