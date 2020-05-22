public void addLast(E obj)
{
    Node<E> newNode = new Node<E>(obj);
    if(head == null) 
    {
        head = tail = newNode;
    }   
    else
    {
        tail.next = newNode;
        tail = tail.next;
    }
    currentSize++;
}