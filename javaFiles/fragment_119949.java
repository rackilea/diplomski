// Assuming non-null root node with method declaration
private Node floor(Node root, Key key, Node lowestNode) {
    if(key.compareTo(root.getKey()) <= 0) {
        if(root.getLeft() != null) {
            return floor(root.getLeft(), key, lowestNode);
        } else {
            return root.compareTo(lowestNode) < 0 ? root : lowestNode;
        }
     } else {
        if(root.getRight() != null) {
           lowestRightNode.add(root);
           return floor(root.getRight(), key, lowestNode);
        } else {
           return lowestNode;
     }
}