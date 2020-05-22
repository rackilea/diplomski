Node categories = doc.getElementsByTagName("categories").item(0);
NodeList categorieslist = categories.getChildNodes();
while (categorieslist.getLength() > 0) {
    Node node = categorieslist.item(0);
    node.getParentNode().removeChild(node);
}