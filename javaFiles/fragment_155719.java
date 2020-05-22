public Node insertNodeAtTail(Node head, int data) {
 if(head == null) {
    head = new Node(data);
 }
 else{
    head.next = insertNodeAtTail(head.next,data);
 }
 return head;
}