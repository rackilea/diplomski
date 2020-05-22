String html = "<p></p><div></div><p>Hello<br/>world</p><p></p>";
Document doc = Jsoup.parse(html);

for (Element element : doc.select("*")) {
    if (!element.hasText() && element.isBlock()) {
        element.remove();
    }
}

System.out.println(doc.body().html())