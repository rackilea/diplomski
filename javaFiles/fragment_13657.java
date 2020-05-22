public static String getFirstTextContent(Document node, String tagName) {
    NodeList locations = node.getElementsByTagName(tagName);
    if (locations.getLength() > 0) {
        return locations.item(0).getTextContent();
    }

    return "";
}