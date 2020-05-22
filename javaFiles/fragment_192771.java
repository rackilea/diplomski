private Node remove(int i) {
    Node node = head;
    do {
        if (node.next.element == i) {
            Node n = node.next;
            node.next = n.next;
            if (n == head) { // removal of head
                head = node;
            }
            return n;
        }
        node = node.next();
    } while(node != head);
    return null;
}