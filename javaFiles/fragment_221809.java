public class Node {
    int data;
    Node next = null;

    public Node (int age) {
        data = age;
    }

    // insert a node to the head of a linked list and return the head
    public Node insertNodeToHead(Node n) {
        n.next = this;
        return n;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);

        // insert new node
        Node insertNew = new Node(0);
        Node current = root.insertNodeToHead(insertNew);

        while (current != null) {
            System.out.println(current.data); 
            current = current.next;
        }
    }
}