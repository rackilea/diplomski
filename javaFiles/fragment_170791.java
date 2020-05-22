public void append(DLNode newNode) {
    if (head == null ) {
        head = newNode;
    }
    else {
        DLNode curNode = head;
        while (curNode.next != null)
            curNode = curNode.next; 
        curNode.next = newNode;
        newNode.prev = curNode;
    }

}

public void remove(DLNode curNode) {
    DLNode sucNode = curNode.next;
    DLNode predNode = curNode.prev;
    if (sucNode != null)
        sucNode.prev = predNode;
    if (predNode != null)
        predNode.next = sucNode;
    else if (curNode == head)
        head = sucNode;
    else
        throw new IllegalArgumentException();

}