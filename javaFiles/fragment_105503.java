public void deleteNode(int data) {
    Node current = head;
    while (current != null && current.data != data) {
        current = current.next;
    }
    deleteNode(current);
    // Note: We silently do nothing if 'data' not found
}
private void deleteNode(Node node) {
    if (node != null) {
        // Here we can rely on 'node' actually being in our list
        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
    }
}