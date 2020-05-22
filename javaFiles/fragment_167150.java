private static Node shallow_clone(Node head) {
if (head == null) {
    return null;
}

Node temp = new Node(head.getData());
temp.setNext(head.getNext());  // Just copy the reference

return temp;