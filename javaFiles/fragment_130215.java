public BasicLinkedList<T> addToFront(T data) {
    Node n = new Node(data);
    // The list was empty so this if is true
    if(head == null){
        head = n;
        tail = n;
    }
    n.next = head;
    // now head == n and n.next == head == n so you've got a circle
    head = n;
    size++;
    return this;
}