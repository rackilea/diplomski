public static Node insertInOrder() {
    Node first = null;
    while (inFile.hasNext()) {
        String value = inFile.next().toString();
        first = insert(first, value);
    }
    return first;
}

/**
 * Insert in a sub-list, yielding a changed sub-list.
 * @param node the sub-list.
 * @param value
 * @return the new sub-list (the head node might have been changed).
 */
private static Node insert(Node node, String value) {
    if (node == null) { // End of list
        return getNode(value);
    }
    int comparison = node.value.compareTo(value);
    if (comparison >= 0) { // Or > 0 for stable sort.
        Node newNode = getNode(value); // Insert in front.
        newNode.next = node;
        return newNode;
    }
    node.next = insert(node.next, value); // Insert in the rest.
    return node;
}