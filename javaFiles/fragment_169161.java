public boolean search(char c) {
    return search(head, c);
}


private boolean search(Csc2001Node node, char c) {
    if (node == null)
        return false;
    else if (node.ch == c)
        return true;
    else
        return search(node.next, c); 
}