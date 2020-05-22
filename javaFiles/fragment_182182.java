Document doc = Jsoup.parse(html);
Element links = doc.select("a");
for (Element l : links) {
    // grab the title attribute value
    System.out.println(l.attr("title"));
}