public void insertBefore(int num, String data)
{
    Link current =  head;
    for (int count = 0; count < num && current.next != null; ++count)
    {
        current = current.next;
    }
    Link n = new Link(data);
    n.next = current;
    if (current.previous != null)
        current.previous.next = n;
    n.previous = current.previous;
    current.previous = n;
}