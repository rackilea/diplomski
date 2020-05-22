public BasicLinkedList<T> addToFront(T data) {
    Node n = new Node(data);
    if(head == null){
        tail = n;
    }
    n.next = head;
    head = n;
    size++;
    return this;
}