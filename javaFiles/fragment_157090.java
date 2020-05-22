public E peek() {
    return first.item; // first is null if stack is empty!
}

public void pop() {
    first = first.next; // first is null if stack is empty!
    size--;
}