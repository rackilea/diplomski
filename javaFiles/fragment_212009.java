public Node findNode(Node root, int position) {
    ArrayList<Node> a = new ArrayList<Node>();
    populateNodes(root, a);
    return a.get(position);
}

private void populateNodes(Node node, ArrayList<Node> a) {
    if (node == null) return;
    populateNodes(node.left, a);
    a.add(node);
    populateNodes(node.right, a);
}