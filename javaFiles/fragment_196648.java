private static class Node<E> {
    private volatile E item;
    private volatile Node<E> next;
    private static final AtomicReferenceFieldUpdater<Node, Node> nextUpdater =
        AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "next");
    private static final AtomicReferenceFieldUpdater<Node, Object> itemUpdater =
        AtomicReferenceFieldUpdater.newUpdater(Node.class, Object.class, "item");
    Node(E x) { item = x; }
    Node(E x, Node<E> n) { item = x; next = n; }
    E getItem() { return item; }
    boolean casItem(E cmp, E val)
        { return itemUpdater.compareAndSet(this, cmp, val); }
    void setItem(E val) { itemUpdater.set(this, val); }
    Node<E> getNext() { return next; }
    boolean casNext(Node<E> cmp, Node<E> val)
        { return nextUpdater.compareAndSet(this, cmp, val); }
    void setNext(Node<E> val) { nextUpdater.set(this, val); }
}