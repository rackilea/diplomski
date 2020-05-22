public Node get(int k) {
    Node n = head;
    while (k > 0) {
       n = n.next;  // or n.next() if need be
       k--;
    }
    return n;
}