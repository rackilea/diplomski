public void addLast(int obj)
{
    if (head == null) {
        // If we add an element for the first time
        head = new ListNode();
        head.data = obj;
    } else {
        newNode = head;
        while (newNode.link != null) {
            newNode = newNode.link;
        }
        // Now newNode.link is null
        // Creating the next node
        ListNode temp = new ListNode();
        temp.data = obj;
        // Assigning this new node to the last node's neighbor
        newNode.link = temp;
    }
}