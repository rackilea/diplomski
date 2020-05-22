String str = "There are <span class='newStyle'> two </span> workers from the <span class='oldStyle'>Front of House</span>";
    Document doc = Jsoup.parse(str);
    Element body = doc.selectFirst("body");
    List<Node> childNodes = body.childNodes();
    for (int i = 0; i < childNodes.size(); i++) {
        Node node = body.childNodes().get(i);
        if (node instanceof TextNode) {
            System.out.println(i + " -> " + node.toString());
        } else {
            Element element = (Element) node;
            System.out.println(i + " -> " + element.text());
        }
    }