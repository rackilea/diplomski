private Node getElementRec(Node currentNode, int i, String ... names) {
    if (null == names || names.length == i)
        return currentNode;
    else {
        Node child = currentNode.getChildWithName(names[i]);
        return getElementRec(child, i+1, names);
    }
}