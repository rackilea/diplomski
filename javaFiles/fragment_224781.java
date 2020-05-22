public class Node<T> {

    private T item;
    private Node<T> next;

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    public Node(T item) {
        this.item = item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public static Node<Integer> reverseLinkedList(Node<Integer> head) {
        if (head.next != null){
            Node<Integer> prev = head.next;
            Node<Integer> result = reverseLinkedList(prev);
            prev.next = head;
            return result;
        } else {
            return head;
        }
    }

    private static Node<Integer> kReverseLinkedList(Node<Integer> head, Node<Integer> cursor, int counter, int k) {
        Node<Integer> result;
        if (cursor.next == null){
            result = reverseLinkedList(head);
            head.next = null;
        } else if (counter > 0){
            result = kReverseLinkedList(head, cursor.next, counter-1, k);
        } else {
            Node<Integer> next = cursor.next;
            cursor.next = null;
            result = reverseLinkedList(head);
            head.next = kReverseLinkedList(next, next, k, k);
        }
        return result;
    }

    public static Node<Integer> kReverseLinkedList(Node<Integer> head, int k) {
        Node<Integer> result = null;
        if (head != null){
            result = head;
            if (k > 1) {
                result = kReverseLinkedList(head, head, k-1, k-1);
            }
        }
        return result;
    }

    public static void print(Node<Integer> n) {
        if (n != null){
            System.out.print(n.item+" ");
            print(n.next);
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] data = {3,4,5,2,6,1,9};
        Node<Integer> head = new Node<>(data[0]);
        Node<Integer> tail = head;
        for (int i = 1; i < data.length; i++) {
            Node<Integer> n = new Node<>(data[i]);
            tail.setNext(n);
            tail = n;
        }
        print(head);
        head = kReverseLinkedList(head, 3);
        print(head);
    }
}