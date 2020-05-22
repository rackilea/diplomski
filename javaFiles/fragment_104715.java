class LinkedStack<T> {
    // references to T refer to LinkedStack's T.

    static class Node<T> {
        // references to T refer to Node's T.
        T data;
    }

    // ...
    Node<T> node;
}