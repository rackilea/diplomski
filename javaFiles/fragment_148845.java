public Node findLastElement(Node root) {
    if(root == null) {
        return null;
    }
    Node x = root;
    while(x.right != null) {
        x = x.right;
    }
    return x;
}