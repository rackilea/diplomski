public static void printNodeTree(Node n) {
    // print XML Element name:
    System.out.println("ELEM: " + n.getNodeName());

    // print XML Element attributes:
    NamedNodeMap attrs = n.getAttributes();
    if (attrs != null) {
        for (int i = 0; i < attrs.getLength(); i++ ) {
            Node attr = attrs.item(i);
            System.out.println("ATTR: " + attr.getNodeName() + " = " + attr.getNodeValue());
        }
    }

    NodeList nodeList = n.getChildNodes();

    // print XML Element text value
    for (int i = 0; i < nodeList.getLength(); i++) {
        Node currentNode = nodeList.item(i);
        if (currentNode.getNodeType() == Node.TEXT_NODE) {
            String text = currentNode.getNodeValue();
            if (text != null && text.matches("\\S+")) {
                System.out.println("TEXT: " + text);
            }
        }
    }

    // recurse over child elements 
    for (int i = 0; i < nodeList.getLength(); i++) {
        Node currentNode = nodeList.item(i);
        if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
            printNodeTree(currentNode);
        }
    }
}