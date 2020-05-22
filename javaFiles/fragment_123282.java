private static void fillRight(Node node) {
    if (node.right != null || node.x > 10)
        return;

    node.right = new Node(node.x + 1, node.y);
    node.right.left = node; // CURRENT NODE IS LEFT OF NEW NODE!
    fill(node.right);
}

private static void fillLeft(Node node) {
    if (node.left != null || node.x <= 0)
        return;

    node.left = new Node(node.x - 1, node.y);
    node.left.right = node; // CURRENT NODE IS RIGHT OF NEW NODE!
    fill(node.left);
}