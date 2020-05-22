public String buildHTML(String htmlString, String textToInject)
{
    // Create a document from string
    Document doc = Jsoup.parse(htmlString);

    // create the script tag in head
    doc.head().appendElement("script")
            .attr("type", "text/javascript")
            .text("window.onload=function(){alert(\'hello?\';}");


    // Create div tag
    Element div = doc.body().appendElement("div").attr("id", "1");

    // Create pre tag
    Element pre = div.appendElement("pre");
    pre.text(textToInject);

    // Return as string
    return doc.toString();
}