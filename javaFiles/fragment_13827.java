final Document doc = Jsoup.parse(new File(".\\source.xhtml"), "UTF-8");

for (Element result : doc.select("div")) {
    final String text = ((TextNode) result.childNode(0)).getWholeText();
    System.out.println(text);
}