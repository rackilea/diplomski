public void insertAfter(DLNode curNode, DLNode newNode) {
    DLNode sucNode;

    if (curNode == null) {
        sucNode = head;
        head = newNode;
    } else {
        sucNode = curNode.next;
        curNode.next = newNode;
    }
    newNode.prev = curNode;

    newNode.next = sucNode;
    if (sucNode != null)
        sucNode.prev = newNode;
}