public Node find(Node node, int target) {
    if(node == null || node.value == target) {
        return node;
    }
    if(node.value > target) {
        return find(node.left, target);
    } else {
        return find(node.right, target);
    }
}