public void reverse(){ // TODO: Last node links to a null node
    Node prev = null;
    Node current = head.next;
    Node next = null;

    while(current != null){
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }

    head.next = prev;  // *** The only change ***
}