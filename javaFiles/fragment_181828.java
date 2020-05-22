public E get(int sub)
{
    Node<E> cursor = head; //you forgot the generics here

    for (int c = 1; c <= sub; c++)
    {
        cursor = cursor.next; 
    }

    return cursor.contents;
}


 public class Node <E>
{
    public E contents; 
    public Node<E> next = null; //you also even suppressed the raw type here

    public Node(E element)
    {
        this.contents = element; 
    }
}