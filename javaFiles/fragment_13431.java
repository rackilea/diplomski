private static class Node {
    int count;
    Node next;
    //getters and setters...
}

//this function just swaps data, no need to swap the nodes prev and next
//(note that yours is an algorithm design issue)
private void swap(Node node1, Node node2) {
    int aux = node1.getCount();
    node1.setCount(node2.getCount());
    node2.setCount(aux);
}