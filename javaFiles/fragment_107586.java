public void insert(Node node)
{
    if(this.head == null) {
        this.head = node;
        this.tail = node;
    }
    else {
        this.tail.next = node;
        this.tail = this.tail.next;
    }

    this.length++;
}