while ( p2.next != null ) {
    p2 = p2.next;
    if (p2.next != null) {
        p2 = p2.next;
        p1 = p1.next;
    }
}