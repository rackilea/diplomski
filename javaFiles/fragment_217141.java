if (current.right!=null) {
    Node<E> tmp = current;
    current = current.right;
    count += getNumberOfInteriorNodes();
    current = tmp;
}