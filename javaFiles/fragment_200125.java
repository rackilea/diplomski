public static class Node<T extends Comparable<T>> { //HERE

    private T value;

    public Node(T val) {
        this.value = val;
    }

    public void insert(T val) {
        if (value.compareTo(val) > 0) {
            new Node<T>(val);
        }
    }
}