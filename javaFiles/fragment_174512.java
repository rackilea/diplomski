public LinkedLargeInteger(long largeLong) {
    String s = Long.toString(largeLong);
    head = new Node();
    tail = head;
    size = 0;
    for (int i = 0; i < s.length(); i++) {
    // You were putting the whole number, not the digits
        tail.next = new Node(Long.parseLong(String.valueOf(s.charAt(i))), null); // <<==
        tail = tail.next;
        size++;
    }
}