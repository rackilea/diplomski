String url = "http://www.latijnengrieks.com/vertaling.php?id=5368";
Document document = Jsoup.parse(new URL(url).openStream(), "ISO-8859-1", url);
Element paragraph = document.select("div.kader p").first();

for (Node node : paragraph.childNodes()) {
    if (node instanceof TextNode) {
        System.out.println(((TextNode) node).text().trim());
    }
}