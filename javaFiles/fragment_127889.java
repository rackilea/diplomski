if ( previous != null ) {
    Node sig = next.nextNode;

    previous.nextNode = next;
    next.nextNode = current;
    current.nextNode = sig;
} else {
    Node sig = next.nextNode;

    head = next;
    next.nextNode = current;
    current.nextNode = sig;
}