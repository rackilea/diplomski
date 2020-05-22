public static boolean hasChildElements(Element el) {
    NodeList children = el.getChildNodes();
    for (int i = 0;i < children.getLength;i++) {
        if (children.item(i).getNodeType() == Node.ELEMENT_NODE) 
            return true;
        }
    }
    return false;
}