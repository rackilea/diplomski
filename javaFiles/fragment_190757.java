private E compressToRoot(E node) {
    if (parentMap.get(node) != node)
        parentMap.set(node, compressToRoot(node));
    return parentMap.get(node);
}

private E compressToRoot(E cursor) {
    E node;
    ArrayList<E> nodes = new ArrayList<E>();
    while ((node = parentMap.get(cursor)) != cursor)  {
        nodes.add(cursor);
        cursor = node;
    }

    for (node : nodes)
        parentMap.set(node, cursor);

    return cursor;
}