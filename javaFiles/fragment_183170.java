String html = "html";
Document doc = Jsoup.parse(html);
Elements img = doc.getElementsByTag("img");
for (Element element : img) {
    String src = element.attr("src");
    // READ image using the existing src, convert to base64 (using java.util.Base64) 
    String base64 = ""; 
    element.attr("src", "data:image/png;base64,"+);
}
String newHtml = doc.html();
browser.setText(newHtml);