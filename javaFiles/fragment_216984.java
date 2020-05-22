String input = "<div class=\"class_Name\">\n\"Unknown text\"\n"
        + "<img src=\"link_To_Image\">\n\"Unknown text\"\n</div>";

    Document doc = Jsoup.parse(input);
    Element element = doc.select("div.class_Name").first();

    List<Node> nodes = element.childNodes();
    for (Node n : nodes) {
        System.out.println(n);
    }