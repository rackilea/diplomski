File input = new File("input.html");
Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

Elements spans = doc.select("span"); 
for (Element element : spans) {
    System.out.println(element.html());
}