String html = "<html><head><title>First parse</title></head>"
              + "<body><p>Parsed HTML into a doc.</p><a href=\"http://google.com\">Link</a></body></html>";
Document doc = Jsoup.parse(html);   

Elements links = doc.getElementsByTag("a");
for (Element element : links) {
    element.attr("onclick", "openFunction('"+element.attr("href")+"')");
    element.attr("href", "#");
}

System.out.println(doc.html());