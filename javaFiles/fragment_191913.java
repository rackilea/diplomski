static void depthTraversal(Node root, int depth, int maxDepth) {
    if (depth == maxDepth) { // if you reached max level - exit
        return;
    }
    if (root == null || root.getChildNodes() == null) { // if you reached null child - exit
        return;
    }
    root.getChildNodes().forEach((key, value) -> value.forEach(node -> {
        // do what you need with your nodes
        depthTraversal(node, depth + 1, maxDepth); // recursively go to next level
    }));
}