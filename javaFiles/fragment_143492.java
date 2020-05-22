public void addEnd(T item) {
    if (nodes == null) {
        nodes = new NodesList<T>(item, null);
        return;
    }
    if (nodes.tail == null) {
        nodes.tail = new NodesList<T>(item, null);
    } else {
        nodes.tail == new NodesList<T>(nodes.tail, item);
    }
}