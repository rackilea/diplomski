public Object deQueue() {
    Node previous = last;
    Node current = last.next;
    Object num = null;
    if (count == 0) System.out.println("empty queue");
    else {
        while (current.next != null) {
            previous = previous.next;
            current = current.next;
        }
        num = first.e;
        first = previous;
        first.next = null; <--- HERE
        count--;
    }
    return num;
}