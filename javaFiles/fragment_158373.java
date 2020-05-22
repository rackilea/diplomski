@SuppressWarnings("unchecked")
 public void remove(int index)
 {
    if(index < 0 || index > size)
    {
        throw new IndexOutOfBoundsException();
    }
    Node n = first;
    for(int i = 0; i < index; i++)
    {
        n = n.next;
    }
    // n points to node to remove
    n.prev.next = n.next;
    n.next.prev = n.prev;
    if (index == 0)
    {
        if(size == 1)
        {
            first = null;
        }
        else
        {
            first = first.next;
        }
    }
    size--;
}