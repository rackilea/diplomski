private Node<E> insert(E s, Node<E> T) throws Exception {
    ...
    else {
        System.out.println("Item already present.");
        throw new Exception("Item already present.");
    }
    return T;
}