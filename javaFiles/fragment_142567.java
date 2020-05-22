Document doc = Jsoup.connect("http://example.com").get();
Element element = doc.getElementById("theIdValue");
// Read the text of the element:
String text = element.text();
// Or read the HTML of it
String html = element.html();