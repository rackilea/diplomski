NodeList removedChildren = removedNode.getChildNodes();
for (int i = 0 ; i < removedChildren.getLength(); i++) {
    Node child = removedChildren.item(i);
    if (child.getNodeType() == Node.ELEMENT_NODE) {
        parentNode.appendChild(child);
    }
}