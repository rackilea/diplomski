while (n1 != null) {
    if (n1.data != n2.data) {
        return false;
    }
    n1 = n1.next;
    n2 = n2.next;
}