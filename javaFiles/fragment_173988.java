class ListNode {
    public int data; // data stored in this node
    public ListNode next; // a link to the next node in the list

    public ListNode() { } //Default constructor. You will need this

    // Create this constructor for ListNode
    public ListNode(ListNode other){
        this.data = other.data;
        this.next = other.next;
    }
}