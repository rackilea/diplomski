private Node _insert (int element, Node t) {
    if (t == null) {
        t = new Node(null, element);
    }
    return t;
}