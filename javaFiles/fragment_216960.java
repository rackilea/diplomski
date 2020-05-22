public class Node<T> {
    public Node<T> left;
    public Node<T> right;
    public T value;

    public Node(Node<T> left, Node<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value; 
    }

    public Node(T value) {
        this(null, null, value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        Node<T> otherNode = (Node<T>) other;

        if (other == null) return false;
        if (this.value == null && otherNode.value != null) return false;
        if (this.value != null && otherNode.value == null) return false;

        return this.value.equals(otherNode.value);
    }

    @Override
    public String toString() {
        return String.format("{ \"v\" : %s, \"l\" : %s, \"r\" : %s }", value, left, right);
    }
}