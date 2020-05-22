public boolean insert(E s) 
{
    root = insert(s, root);
    if (root == null) {
        return false;
    }
    root.setParent(findParent(root.getData()));
    return true;
}

private Node<E> insert(E s, Node<E> T) {
    ...
    else {
        System.out.println("Item already present.");
        return null;
    }
    return T;
}