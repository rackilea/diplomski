public static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    protected final T data;
    protected final List<Node<T>> adj;

    public Node(T data) {
        this.data = data;
        adj = new ArrayList<Node<T>>();
    }

    @Override
    public int compareTo(Node<T> other) {
        return data.compareTo(other.data);
    }
}