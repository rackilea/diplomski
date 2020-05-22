if (currentNode.prev == null) { // is head 
    head = currentNode.next;
} else {
    currentNode.prev.next = currentNode.next;
}
if (currentNode.next == null) { // is tail
    tail = currentNode.prev;
} else {
    currentNode.next.prev = currentNode.prev;
}