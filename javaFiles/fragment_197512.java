class Node {
    public int data;
    public Node link;

    public Node(int data, Node link) {
        this.data = data; 
        this.link = link; 
    }
}

class Main {
    public static Node listGenerator(int size) {
        Node next = null;
        Node head = null;

        for (int i = 1; i < size; i++) {
            head = new Node((int)(Math.random() * 100) + 1, next);
            next = head;
            head = null;
        }

        head = new Node((int)(Math.random() * 100) + 1, next);
        return head;     
    }

    public static void main(String[] args) {
        Node head = listGenerator(6);

        while (head != null) {
            System.out.print(head.data + "->");
            head = head.link;
        }

        System.out.println("null");
    }
}