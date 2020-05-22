public void insert(int x) {
    root = insertPrivate(root, x);
}

private Node insertPrivate(Node node, int x) {
    if(node == null) {
        node = new Node(x);
    } 
    else {
        if(x < node.info) {
            node.left = insertPrivate(node.left, x);
        } 
    else if (x > node.info) {
            node.right = insertPrivate(node.right, x);
        }
    }
    return node;
}