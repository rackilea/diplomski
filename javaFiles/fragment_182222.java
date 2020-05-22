private static Element getFirstChildElement(org.w3c.dom.Node node) {
    org.w3c.dom.Node child = node.getFirstChild();
    while (child != null &&
            child.getNodeType() != org.w3c.dom.Node.ELEMENT_NODE) {
        child = child.getNextSibling();
    }
    return (Element) child;
}

public static Element getNextSiblingElement(org.w3c.dom.Node node) {
    org.w3c.dom.Node sibling = node.getNextSibling();
    while (sibling != null &&
            sibling.getNodeType() != org.w3c.dom.Node.ELEMENT_NODE) {
        sibling = sibling.getNextSibling();
    }
    return (Element) sibling;
}