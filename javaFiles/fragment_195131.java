if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
    Element childElement = (Element) children.item(i);
    String attr = findAttrInChildren(childElement, tag);
    if (attr != null)
        return attr;
}