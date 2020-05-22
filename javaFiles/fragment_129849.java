public void enQueue(Object n) {
    Node temp = new Node(n);
    temp.next = last;
    last = temp;
    if (first == null) { <--- HERE
        first = temp;
    }
    count++;
}