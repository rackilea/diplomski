Document doc = Jsoup.parse("<html><body><div/>" + 
    "<div id=\"navDiv\">" + 
        "<a href=\"href1\">link1</a>" +
        "<a href=\"href2\">link2</a><" +
    "</div></body></html>");
Element div = doc.select("div#navDiv").first();