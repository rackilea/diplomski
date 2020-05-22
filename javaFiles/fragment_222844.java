public boolean isValid(Node root) {
    LinkedList<Node> nodesToCheck = new LinkedList<>();
    nodesToCheck.offer(root);
    while (!nodesToCheck.isEmpty()) {
        Node current = nodesToCheck.poll();
        if (current.left != null) {
            if (current.data < current.left.data)
                return false;
            nodesToCheck.offer(current.left);
        }
        if (current.right != null) {
            if (current.data > current.right.data)
                return false;
            nodesToCheck.offer(current.right);
        }
    }
    return true;
}