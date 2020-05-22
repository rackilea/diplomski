Node root; Comparator comp;
Node current = root;
while (current.next != null) {
    E data = current.data;
    Node i = current;
    while (i.previous != null && comp.compare(data, i.previous.data) < 0) {
        i.data = i.previous.data;
        i = previous;
    }
    i.data = data;
    current = current.next;
}