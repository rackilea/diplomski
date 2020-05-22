if (head == null) {  // empty list
    head = n
}
else {
    head.setPrev(n);
    n.setNext(head);
    head = n;
}