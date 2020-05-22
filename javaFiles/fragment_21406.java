public Node deleteAlternate(Node head)
{
    Node p = head;
    while (p != null) {
        if (p.next != null) {
            p.next = ... // delete the next.
        }
        p = p.next;
    }
    return head; // head is never deleted.
}