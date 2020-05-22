public Node findLastElement(Node root) {
    if (root == null) {
        return null;
    }
    if (root.right == null) {
        return root;
    }
    return findLastElement(root.right);
}