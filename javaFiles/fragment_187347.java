private Node<T> search(T key) {
    Node<T> node = head;
    boolean found = false;

    while (!found) {
        //special case to return a node containing null - indicates value not in list
        if (node == null) return new Node(null);
        //We found it!
        else if (node.getData().equals(key)) found = true;
        //Go to the next one over if it's not too high.
        else if (node.getNext() != null && compare(node.getNext().getData(), key) <= 0) node = node.getNext();
        //It was too high, so go down instead.
        else node = node.getDown();
    }
    return node;
}