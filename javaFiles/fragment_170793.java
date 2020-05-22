public void prepend(DLNode newNode) {
    if (head == null) {
        newNode.next = null;
        head = newNode;
        newNode.prev = null;
    } else {
        head.prev = newNode;
        newNode.next = head;
        newNode.prev = null;
        head = newNode;
    }
}