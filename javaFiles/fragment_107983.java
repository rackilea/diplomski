int comparison = key.compareTo(node.getKey());
if (comparison < 0) {
    return new Node<K, E>(
        insert(node.getLeft(), key, elem),
        node.getKey(), node.getElem(),
        node.getRight());
}
else if (comparison == 0) {
    return node;
}
else {
    return new Node<K, E>(
        node.getLeft(),
        node.getKey(), node.getElem(),
        insert(node.getRight(), key, elem));
}