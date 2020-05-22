final String html = "<p><strong>Tarthatatlan biztonsági viszonyok</strong></p>"
        + "<p><strong>Tarthatatlan biztonsági viszonyok</strong></p>";
Document doc = Jsoup.parse(html);

for( Element element : doc.select("p") )
{
    System.out.println(element.text());
    // eg. you can use a StringBuilder and append lines here ...
}