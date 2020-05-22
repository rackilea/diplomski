class Node<E> {
    E item;
    Node<E> next;

    Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return item + (next == null ? "" : " -> " + next);
    }

}