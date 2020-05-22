public static String getFirstLevelTextContent(Node node) {
    NodeList list = node.getChildNodes();
    StringBuilder textContent = new StringBuilder();
    for (int i = 0; i < list.getLength(); ++i) {
        Node child = list.item(i);
        if (child.getNodeType() == Node.TEXT_NODE)
            textContent.append(child.getTextContent());
    }
    return textContent.toString();
}