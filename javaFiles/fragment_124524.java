public class LinkedList {

    Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public void rotateLeft() {
        System.out.println("<-");
        if (head != null) { // otherwise it is empty list
            Node temp = head;
            if (head.getNext() != null) { // otherwise it is single item list
                head = head.getNext();
            }

            Node tail;
            if (head.getNext() != null) {
                // more than 2 items in the list
                tail = head.getNext();
            } else {
                // only 2 items in the list
                tail = head;
            }
            while (tail.getNext() != null) {
                if (tail.getNext() != null) {
                    tail = tail.getNext();
                }
            }
            tail.setNext(temp);
            temp.setNext(null);
        }
    }

    public void rotateRight() {
        System.out.println("->");
        if (head != null) { // otherwise it is empty list
            Node tail = null;
            Node current = head;

            while (current.getNext() != null) {
                tail = current;
                current = current.getNext();
            }
            if (tail != null) { // otherwise it is single item list
                tail.setNext(null);
                current.setNext(head);
                head = current;
            }
        }
    }

    public void printList() {
        Node cursor = head;
        while (cursor != null) {
            System.out.print(cursor.data + ", ");
            cursor = cursor.getNext();
        }
        System.out.println();
    }

    public void add(Object data) {
        Node temp = new Node(data);

        if (head == null) {
            head = temp;
        } else {
            Node current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(temp);
        }
    }

    public static void main(String[] args) {
        LinkedList r = new LinkedList();
        r.add(1);
        r.add(2);
        r.add(3);
        r.add(4);
        r.add(4);
        r.add(5);
        r.printList();
        r.rotateLeft();
        r.printList();
        r.rotateLeft();
        r.printList();
        r.rotateRight();
        r.printList();
        r.rotateRight();
        r.printList();
    }

}