public void deleteNode(int value)
{
    if(count == 0) {
        return;
    } else if (count == 1){
        // delete this node. I'm not quite sure what you mean by use front() in your instruction
    } else {
        Node x = Node first; // This should be the first node in the list
        while(x != null && x.next != null) {
            if(x.value == value) {
                if(x == first) {
                    first = x.next; // If your first node is bad, make 2nd node your first node
                } else {
                    prev.next = x.next; // This skips the current node, with the sought-after value
                }
            } else {
                x = x.next; // Traverse to check the next node
            }
        }
    }
}