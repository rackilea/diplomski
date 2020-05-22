public E getMax()
{
    if (isEmpty())
        throw new NoSuchElementException(" error " );

    Node n = first;

    E max = n.data;

    while (n != null)
    {
        if (n.data.compareTo(max) > 0) // if n.data > max
            max = n.data;

        n = n.next; // move to the next node
    }

    return max;
}