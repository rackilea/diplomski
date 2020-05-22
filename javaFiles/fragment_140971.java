@Override
public T next() {
    Object item = node.getItem();
    node = node.getRight();
    return (T)item;
}

@Override
public boolean hasNext() {
    return node != null;
}