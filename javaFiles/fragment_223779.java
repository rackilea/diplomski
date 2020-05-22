public Document cleanNameSpace(Document doc) {

    NodeList list = doc.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
        removeNamSpace(list.item(i), "");
    }

    return doc;
}
private void removeNamSpace(Node node, String nameSpaceURI) {

    if (node.getNodeType() == Node.ELEMENT_NODE) {
        Document ownerDoc = node.getOwnerDocument();
        NamedNodeMap map = node.getAttributes();
        Node n;
        for (!(0==map.getLength())) {
            n = map.item(0);
            map.removeNamedItemNS(n.getNamespaceURI(), n.getLocalName());
        }
        ownerDoc.renameNode(node, nameSpaceURI, node.getLocalName());
    }
    NodeList list = node.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
        removeNamSpace(list.item(i), nameSpaceURI);
    }
}