public class Main {

    private static int count(Node head) {
        if (head == null) return 0;
        Node current = head;
        int count = 0;

        while(current != null) {
            count++;
            current = current.next;
        } return count;
    }

    private static void sortLL(Node head) {
        if (head == null) return;
        Node current = head;
        Node i,j;

        int length = count(head);

        for(i=head; i!=null; i=i.next) {
            for(j=i.next; j!=null; j=j.next) {
                if(i.data>j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }

    }

    private static void display(Node head) {
        if (head == null) return;
        Node current = head;

        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        } System.out.println(current);
    }

    private static class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }


    }

    public static void main(String args[]) {
        Node head = new Node(5);
        Node first = new Node(2);
        Node second = new Node(3);
        Node third = new Node(4);
        Node fourth = new Node(1);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;

        sortLL(head);
        display(head);
    }

}