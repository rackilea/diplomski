public void insertNode(int nodeData) {
    // here a new node object is created each time a method is called
    SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

    if (this.head == null) {
        this.head = node;
    } else {
        this.tail.next = node;
    }

    this.tail = node;
}