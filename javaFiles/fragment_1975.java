private static Node generateTree (int depth) {
    if (depth < 0) return null;
    Node currentNode = new Node(depth);
    if (depth > 0) {
        currentNode.left = generateTree(depth-1);
        currentNode.right = generateTree(depth-1);
    }
    return currentNode;
}