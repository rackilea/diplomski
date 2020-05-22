public static List traversePreRecursive(Node node) {
    if (node == null) return new ArrayList();

    List nodeValues = new ArrayList();
    nodeValues.add(node.getValue());
    nodeValues.addAll(traversePreRecursive(node.getLeft()));
    nodeValues.addAll(traversePreRecursive(node.getRight()));

    return nodeValues;
}