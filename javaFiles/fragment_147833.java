public class SortedLinkedList {

    public Node insert(Node head, Comparable a){

        Node curr = head;
        Node prev = null;
        while (curr != null && curr.data.compareTo(a) > 0) {
            prev = curr;
            curr = curr.next;
        }
        if (prev = null) {
            return new Node(a);
        }
        prev.next = new Node(a);
        prev.next.next = curr;
        return head;
    }

    // print doesn't need changing
}