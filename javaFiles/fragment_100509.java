static Node Partition(Node n, int numb) {
    Node tail = n;
    while(tail.next != null) {
        tail = tail.next;
    }
    Node current = n;
    Node root = n;
    Node tailCurrent = tail;
    Node prev = null;
    while(current != tailCurrent) {
        if(current.data < numb) {
            prev = current;
        } else {
            if (prev != null) {
                prev.next = current.next;
            } 
            if (root == current) {
                root = current.next;
            }
            tail.next = current;
            tail = current;
        }
        current = current.next;
    }
    tail.next = null;
    return root;
}