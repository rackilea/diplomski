public static Node merge(Node n1, Node n2) {
    if (n1 == null) return n2;
    if (n2 == null) return n1;

    if (n1.value < n2.value) {
        n1.next = merge(n1.next, n2);
        return n1;
    } else {
        n2.next = merge(n2.next, n1);
        return n2;
    }
}