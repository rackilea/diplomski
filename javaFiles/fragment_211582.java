private static <E> void add(Node<E> head, E item) {
    Node<E> last = head;
    while (last.next != null) {
        last = last.next;
    }
    last.next = new Node<>(item, null);
}