Node<T> prev = head;
while (prev.next != current) {
    prev = prev.next;
}
prev.next = new Node<T>(e);
prev.next.next = current;