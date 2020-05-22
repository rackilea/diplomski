if ( current == tail ) {
    tail = new Node(item);
    current.setNext(tail);
    tail.setPrev(current);
    count++;
    return;
}