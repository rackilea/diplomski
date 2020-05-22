public class Node {
    public Object data;
    public Node next = null;

    Node(data) {
        this.data = data;
    }
}

class LinkedList{
    public Node head = null;
    public Node end = null;

    void insert(Object data) {
        if(head == null) {
            head = new Node(data);
            end = head;
        } else {
            end.next = new Node(data);
            end = end.next;
        }
    }
}