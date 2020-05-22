void show() {
    Node curr = start;
    while (curr.next != null) {
        System.out.println(curr.data);
        curr = curr.next; // This part was missing.
    }
}