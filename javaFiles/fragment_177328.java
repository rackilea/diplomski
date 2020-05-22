public static void read(Node node) {
    if (node == null) {
        return;
    }

    int type = node.getNodeType();
    switch (type) {
    case Node.DOCUMENT_NODE: {
        System.out.println("Doc node; name: " + node.getNodeName());
        read(((Document) node).getDocumentElement());
        break;
    }

    case Node.TEXT_NODE:
        System.out.println("Text node; value: " + node.getNodeValue().replaceAll("\\s", ""));
        break;

    case Node.ELEMENT_NODE: {
        System.out.println("Element node; name: " + node.getNodeName());
        NodeList children = node.getChildNodes();
        int length = children.getLength();
        for (int i = 0; i < length; i++) {
            read(children.item(i));
        }
        break;
    }
    }
}