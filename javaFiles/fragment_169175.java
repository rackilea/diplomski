Document doc = Jsoup.parse("<div>  <a href=\"#\"> innerText  </a> </div>");
System.out.println(doc.html());
Elements rows = doc.getElementsByTag("a");
for (Element element : rows) {
    System.out.println("element = " + element.text());
}