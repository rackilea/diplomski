int size() {
    count = 0;
    Actor current = head;
    while (current != null) {
        current = current.next;
        count++;
    }
    return count;
}