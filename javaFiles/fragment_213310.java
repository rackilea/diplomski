class Node {
    int val;
    Node next;
}

public class LinkedList {
    public Node first;
    public Node last;
    public void addNext(int val) {
        Node node = new Node();
        node.val = val;
        if(last == null) {
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
    }
}