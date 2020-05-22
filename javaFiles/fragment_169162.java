public boolean search(char c) {
    return search(head, c);
}


private boolean search(Csc2001Node node, char c) {
    return node != null && (node.ch == c || search(node.next, c));
}