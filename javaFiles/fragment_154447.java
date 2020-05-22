String html = "<img src=\"some_link\" height=\"200\" width=\"auto\" /><br><br\\>\"Lorem ipsum dolor si amet...\" Name<br>address<br>www.google.com<br>01 42 42 42 42";
    Document doc = Jsoup.parse(html);

    for (Element e : doc.select("*")) {
        for (TextNode tn : e.textNodes()) {
            System.out.println(tn.text());
        }
    }