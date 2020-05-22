public static NodeList merge(NodeList... l) {

    NodeList new_head = new NodeList(0, null);
    NodeList new_node = new_head;

    for(NodeList ln in l) {
        for(; ln != null; ln = ln.next) {
            new_node.next = new NodeList(ln.item, null);
            new_node = new_node.next;
        }
    }
    return new_head.next;
}