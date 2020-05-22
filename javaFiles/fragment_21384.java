// Define a helper method
private static String getChildElementContent(Element e, String childName) {
    NodeList children = e.getElementsByTagName(childName);
    if(children.getLength() > 0) {
        return children.item(0).getTextContent();
    }
    return "";
}