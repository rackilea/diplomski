public void reverse() {
    Node prev = null;
    Node current = head;
    while (current != null) {
        Node next = current.getNext();
        current.setNext(prev);
        prev = current;
        current = next;
    }
    this.head = prev;
}