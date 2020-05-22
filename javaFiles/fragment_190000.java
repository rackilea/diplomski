Document doc = Jsoup.parse(str);
Element div = doc.select("div").first();

for (Node node : div.childNodes()) {
    if (node instanceof org.jsoup.nodes.TextNode) {
        System.out.println(node.toString();
    }
}