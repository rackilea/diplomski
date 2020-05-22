private static int traverseTree(Node n) {
    if (n != null) {
        return n.value + traverseTree(n.left) + traverseTree(n.right);
    } else {
        return 0;
    }
}