public void inOrderTraversal(Node node) {
    if (node != null) {
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }
}