public void insertBef(char ref, char data)
{
    Node current = start;

    while( current.next != null )
    {
        if( current.next.value == ref )
        {
            Node n = new Node(data);
            n.next = current.next;
            current.next = n;
            return;
        }

        current = current.next;
    }
}