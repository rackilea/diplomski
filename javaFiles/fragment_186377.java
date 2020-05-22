if (key == 1) // if key = 1 insert after the existing element
{
    newNode.next = currentNode.next;
    newNode.prev = currentNode;
    currentNode.next = newNode;
    if (newNode.next == null)
        tail = newNode;
    else
        newNode.next.prev = newNode;
}
else if (key == 2) // if key = 2 insert before the existing element
{
    newNode.next = currentNode;
    newNode.prev = currentNode.prev;
    currentNode.prev = newNode;
    if (newNode.prev == null)
        head = newNode;
    else
        newNode.prev.next = newNode;
}