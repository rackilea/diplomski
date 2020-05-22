public class SortedLinkedList {
public static void main(String[] a) {
    Node head = Node.insert(null, 123);
    head = Node.insert(head, 13);
    head = Node.insert(head, 3123);
    head = Node.insert(head, 3);
    head = Node.insert(head, 87);
    head = Node.insert(head, 56);
    head = Node.insert(head, 2332);
    head = Node.insert(head, 5187);
    do {
        System.out.print(head.data + ", ");
        head = head.next;
    } while (head != null);
   }
}

class Node {
public int data;
public Node next;

public Node(int data, Node next) {
    this.data = data;
    this.next = next;
}

public int size(Node list) {
    int count = 0;
    while (list != null) {
        list = list.next;
        count++;
    }
    return count;
}

public static Node insert(Node head, int value) {
    Node T;
    if (head == null || head.data <= value) {
        T = new Node(value, head);
        return T;
    } else {
        head.next = insert(head.next, value);
        return head;
    }
}

}