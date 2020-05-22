if (prev == null) {
    insertAtHead(x);
}

else if (curr == null) {
    insertAtTail(x);
} else {
    Node nNex = new Node(x);
    nNex.setNext(curr);
    prev.setNext(nNex);
}