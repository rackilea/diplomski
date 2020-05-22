public void add(int newEntry){

    Node newNode = new Node(newEntry, null);

    if (start == null) {
        start = newNode;
    }

    else if (newEntry <= start.data) {
        newNode.next = start;
        start = newNode;
    }

    else {
        Node ptr = start;
        Node prv = null; // save a reference to previous node
        while (ptr != null && newEntry > ptr.data) {
            prv = ptr;
            ptr = ptr.next;
        }
        prv.next = newNode;
        newNode.next = ptr;
    }

}