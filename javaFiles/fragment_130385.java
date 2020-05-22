for (Element elem : document.select(".singolo-contenuto a")) {
    if(elem.parents().hasClass("list_attachments")) continue;
    String href = elem.attr("href");
    String text = elem.text();
    elem.replaceWith(new TextNode(href + " " + text, ""));
}
String result = document.select(".singolo-contenuto").text();