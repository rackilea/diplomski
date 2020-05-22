public String toString() {
StringBuilder builder = new StringBuilder();
    Node current = head.next;
    for (int i = 0; i < this.size; i++) {
        builder.append(current.dat); // <<==
        current = current.next;
    }
    return builder.toString();
}