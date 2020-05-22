Document document = Jsoup.connect(url.toString()).get();
Element lyrics = document.select(".lyrics").first();
StringWriter buffer = new StringWriter();
PrintWriter writer = new PrintWriter(buffer);

for (Node node : lyrics.childNodes()) {
    if (node.nodeName().equals("h3")) {
        writer.println(((Element) node).text());
    } else if (node instanceof TextNode) {
        writer.println(((TextNode) node).text());
    }
}

System.out.println(buffer.toString());