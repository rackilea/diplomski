class LinkedList {

    Node head;

    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next=null; } // Constructor
    }


    public static void main(String[] args) {
        //Instantiate your object
        LinkedList.Node node = new LinkedList().new Node(0);
    }
}