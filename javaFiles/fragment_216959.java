public class Tree<T> {
    public Node<T> root;

    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        Tree<T> otherTree = (Tree<T>) other;

        if (other == null) return false;
        if (this.root == null && otherTree.root != null) return false;
        if (this.root != null && otherTree.root == null) return false;

        return equalsNode(this.root, otherTree.root);
    }

    public boolean equalsNode(Node<T> nodeA, Node<T> nodeB) {
        if (nodeA == null && nodeB == null) return true;
        if (nodeA == null && nodeB != null) return false;
        if (nodeA != null && nodeB == null) return false;

        if (nodeA.equals(nodeB)) {
            if (nodeA.value == null && nodeB.value != null) return false;
            if (nodeA.value != null && nodeB.value == null) return false;

            if (nodesEqualSameLeft(nodeA, nodeB) && nodesEqualSameRight(nodeA, nodeB)) {
                return equalsNode(nodeA.left, nodeB.left) && equalsNode(nodeA.right, nodeB.right);
            }

            if (nodesEqualOppositeLeft(nodeA, nodeB) && nodesEqualOppositeRight(nodeA, nodeB)) {
                return equalsNode(nodeA.left, nodeB.right) && equalsNode(nodeA.right, nodeB.left);
            }
        }

        return false;
    }

    public boolean nodesEqualSameLeft(Node<T> nodeA, Node<T> nodeB) {
        return nodesEqual(nodeA.left, nodeB.left);
    }

    public boolean nodesEqualSameRight(Node<T> nodeA, Node<T> nodeB) {
        return nodesEqual(nodeA.right, nodeB.right);
    }

    public boolean nodesEqualOppositeLeft(Node<T> nodeA, Node<T> nodeB) {
        return nodesEqual(nodeA.left, nodeB.right);
    }

    public boolean nodesEqualOppositeRight(Node<T> nodeA, Node<T> nodeB) {
        return nodesEqual(nodeA.right, nodeB.left);
    }

    public boolean nodesEqual(Node<T> nodeA, Node<T> nodeB) {
        return (nodeA == null && nodeB == null) || (nodeA != null && nodeA.equals(nodeB));
    }

    @Override
    public String toString() {
        return root.toString();
    }
}