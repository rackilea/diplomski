String html =
        "<div class=\"c45 c45v0\">\n" +
        "    <p><span>J</span>oseph DeSimone made a bold move back</p>\n" +
        "</div>";

Document doc = Jsoup.parse(html);

//here 'elements' contain only div.c45.c45v0 elements *from* entire document (doc)
Elements elements = doc.select("div.c45.c45v0");
System.out.println(elements);

//now we can manipulate those selected elements
elements.tagName("span");
elements.attr("class", "c6 c77");
System.out.println("---------------");
System.out.println(elements);