public T deq() throws EmptyException {
while(true) {
    Node first = head.get();
    Node next = first.next.get();

    if (first != head.get())
        continue;

    if (next == null) {
        throw new EmptyException();
    }

    T value = next.value;

    if (head.compareAndSet(first, next)) {
        Node last = tail.get();

        if (first == last) {
            tail.compareAndSet(last, next);
        }

        return value;
    }
}