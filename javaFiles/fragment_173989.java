public void stutter() {
    ListNode curr = front;
    while (curr != null) {
        ListNode tempNode = new ListNode(curr);// Using the copy constructor
        curr.next = tempNode;
        curr = tempNode.next;
    }
}