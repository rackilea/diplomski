public class CreateLinkedList {
static class Node {
    String PlayerName;
    Node next = null;

    // Constructor
    Node(String PName) {
        PlayerName = PName;
    }

    // Method to insert a Node
    void InsertNodeAtEnd(String PlayerName) {
        Node transition = new Node(PlayerName);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = transition;
    }

    // Method to print all elements of linked list
    void PrintList() {
        Node n = this;
        while (n != null) {
            System.out.println(n.PlayerName + "\n");
            n = n.next;
        }
    }
}

public static void main(String[] args) {

    Node first = new Node("Sanchez");
    first.InsertNodeAtEnd("Ozil");
    first.InsertNodeAtEnd("Welbeck");
    first.PrintList();
}
}