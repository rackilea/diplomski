private Position<E> duplicate (Position<E> p) {
    Node<E> node = (Node<E>)p;
    Node<E> newNode = new Node<E>();

    //Set the contents of the node as needed.

    if (node.getLeft() != null) {
        newNode.setLeft(duplicate(node.getLeft());
    } 
    if (node.getRight() != null) {
        newNode.setRight(duplicate(node.getRight());
    }
    return newNode;
}