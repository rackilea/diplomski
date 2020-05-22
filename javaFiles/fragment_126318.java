NodeList nodes = docBuilder.parse(new File("1.xml")).getDocumentElement().getChildNodes();
    String[] a = new String[4];
    for (int i = 0, j = 0; i < nodes.getLength(); i++) {
        Node n = nodes.item(i);
        if (n instanceof Element) {
            a[j++] = n.getTextContent().trim();
        }
    }