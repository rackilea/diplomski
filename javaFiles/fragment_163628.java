public int countRight(NodeT node) {
    if (node == null)
        return 0;
    if (node.right == null)
        return countRight(node.left);
    return 1 + countRight(node.left) + countRight(node.right);
}