public Node findLastElement(Node root) {
    if(root == null) {
        return null;
    }
    while(root.right != null)
        root = root.right;
    return root;
}