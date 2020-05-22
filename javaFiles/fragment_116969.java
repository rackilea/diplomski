private static final int indexOf(char c) {
    return c - 'a';
}

private final Node getNodeForChars(Node node, char[] chars, int pos) {
    if (pos == chars.length) {
        return this;
    }
    Node n = children[indexOf(chars[pos])];
    if (n == null) {
        n = new Node();
        children[indexOf(chars[pos])] = n;
    }
    return getNodeForChars(n, chars, pos + 1);
}