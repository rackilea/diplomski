public class LinkedList {
    private Node head;

    public LinkedList() {
        head = new Node(0);
    }
    public LinkedList(Node node) {
        head = node;
    }

    public void add(Node node) {
        Node ptr = head;
        while ( ptr.getNext() != null ) {
            ptr = ptr.getNext();
        }
        ptr.setNext(node);
    }

    ... /// added removeSecondAppear here, but left out to keep it short(er)

    // provided a print() method
}