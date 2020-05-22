class Node {
    private String value;
    private Node left;
    private Node right;

    public Node(String value, Node left, Node right) {
        this.value = value;
        ...
    }

    Node copy() {
        Node left = null;
        Node right = null;
        if (this.left != null) {
            left = this.left.copy();
        }
        if (this.right != null) {
            right = this.right.copy();
        }
        return new Node(value, left, right);
    }
}