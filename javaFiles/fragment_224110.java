Node simpleTreeToList(Node root) {
    if (root == null) {
        return null;
    }
    Node left = root.left;
    Node right = root.right;
    Node head;
    if (left == null) {
        head = root;
    } else {
        head = left;
        left.right = root;
        // root.left is already correct
    }
    if (right == null) {
        head.left = root;
        root.right = head;
    } else {
        head.left = right;
        right.right = head;
        right.left = root;
    }
    return head;
}