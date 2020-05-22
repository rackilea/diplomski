public Node findLca(Node node, int t1, int t2) {
    if(node == null) {
        return null;
    }
    if(node.value > t2 && node.value > t1) {
        // both targets are left
        return findLca(node.left, t1, t2);
    } else if (node.value < t2 && node.value < t1) {
        // both targets are right
        return findLca(node.right, t1, t2);
    } else {
        // either we are diverging or both targets are equal
        // in both cases so we've found the LCA
        // check for actual existence of targets here, if you like
        return node;
    }
}