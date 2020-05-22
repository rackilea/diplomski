if (head.next == head) {
    // ERROR, queue is empty
} else {
    removedElement.next.prev = removedElement.prev;
    removedElement.prev.next = removedElement.next;
}