public void deleteWithValue(int searchValue) {
    DoublyLinkedListNode current = head;

    while (current != null) {

        // If true, then the current node is the one to remove
        if (current.data == searchValue) {  

            if (current == head) {
                head = head.next;
            }

            // Ensure the previous node maintains a link to the next node
            if (current.prev != null) {
                current.prev.next = current.next;
            }

            // Ensure the next node maintains a link to the previous node   
            if (current.next != null) {
                current.next.prev = current.prev;
            }

            break;
        }
        current = current.next;
    }
}