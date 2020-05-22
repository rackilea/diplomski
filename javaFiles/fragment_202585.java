public static NodeList merge(NodeList l1, NodeList l2) {

    NodeList new_head = new NodeList(0, null);
    NodeList new_node = new_head;

    for(; l1 != null; l1 = l1.next) {
        new_node.next = new NodeList(l1.item, null);
        new_node = new_node.next;
    }

    for(; l2 != null; l2 = l2.next) {
        new_node.next = new NodeList(l2.item, null);
        new_node = new_node.next;
    }
    return new_head.next;
}