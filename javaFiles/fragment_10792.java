private final AtomicReference<Node> head = new AtomicReference<>();

@SuppressWarnings("unchecked")
public void offer(final V data) {
    // create new Node
    final Node<V> newNode = new Node<>(data, Thread.currentThread().getName());
    // set root element if it's null
    if (head.compareAndSet(null, newNode)) {
        return;
    }
    // else pass trough all elements and try to set new
    Node<V> pointer = head.get();
    for (;;) {
        if (pointer.next.compareAndSet(null, newNode)) {
            break;
        }
        pointer = pointer.next.get();
    }
}