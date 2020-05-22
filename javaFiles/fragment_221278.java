// Must keep track of head reference, because your Nodes can only go forward
Node evenHead = null;
Node evenTail = null;

Node oddHead = null;
Node oddTail = null;

while (head != null) {
    if(head.data % 2 == 0) {
        if (evenHead == null) {
            // The even list is empty, set the head and tail
            evenHead = new Node(head.data);
            evenTail = evenHead;
        } else {
            // Append to the end of the even list
            evenTail.next = new Node(head.data);
            evenTail = evenTail.next;
        }
    } else {
        // similar code for odd, consider creating a method to avoid repetition 
    }
}