public E find(E x) {
    return find(root,x);
}

private E find(BinaryNode<E> n, E x) {
    if (n == null) {
        return null;
    }
    else if (n.element.equals(x)) {
        return n.element;
    }
    else if (x.compareTo(n.element) < 0) {
        return find(n.left, x);
    }
    else {
        return find(n.right, x);
    }
}