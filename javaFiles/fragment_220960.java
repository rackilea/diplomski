class SimpleStack<T> implements Stack<T> {

    private class Node<T> { ... }

    private Node<T> root = null;

    public void push(T item) {
        if (root == null) {
            root = new Node<T>(item);
        } else {
            Node<T> node = new Node<T>(item, root);
            root = node;
        }
    }

    public T pop() {
        if (root != null) {
            T data = root.getData();
            root = root.getNext();
            return data;
        } else {
            return null;
        }
    }

    public T peek() {
        if (root != null) {
            return root.getData();
        } else {
            return null;
        }
    }
}