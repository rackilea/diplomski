Node lasthead = null;

public void addAtStart(String name, int age) {
    Node newObject = new Node(name, age);
    newObject.next = head;
    if(head == null)
        lasthead = newObject;
    else if(head.next == null)
        lasthead = head;

    head = newObject;

}


public void addAtEnd(String name, int age) {
    Node atEndValue = new Node(name, age);
    lasthead.next = atEndValue;
    lasthead = atEndValue;
}