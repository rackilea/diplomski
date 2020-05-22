public void addToEnd(String item)
{
    ExampleLinkedList newNode = new ExampleLinkedList(data, next);
    data = item;
    next = newNode;
}