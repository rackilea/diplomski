public boolean beFriend(User friend) {
    User node = friend;
    if (root == null) {
        root = node;
        return true;
    }
    if (node.getKey() < root.getKey()) {
        if(root.getLeft() == null) {
            root.setLeft(node);
        } else {
            // recursively call beFriend handing insertion to the child
            root.getLeft().beFriend(node);
        }
    } else if (node.getKey() > root.getKey()) {
        if(root.getRight() == null) {
            root.setRight(node);
        } else {
            // recursively call beFriend handing insertion to the child
            root.getRight().beFriend(node); 
        }
    } else { // node.getKey() == root.getKey() so we replace the previous root
        node.setLeft(root.getLeft());
        node.setRight(root.getRight());
        root = node;
    }
    return true;
}