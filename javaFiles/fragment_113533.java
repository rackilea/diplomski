private static void Node insert(Node list, String value) {
    Node node = list;
    Node previous = null;
    for (;;) {
        if (node == null || node.value.compareTo(value) >= 0) {
            Node newNode = getNode(value);
            newNode.next = node;
            if (previous == null)
                list = newNode;
            else
                previous.next = newNode;
            break;
        }
        // Insert in the rest:
        previous = node;
        node = node.next;
    }
    return list;
}