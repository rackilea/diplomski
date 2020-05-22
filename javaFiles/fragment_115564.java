public Node pop()
{
    if( !isEmpty())
    {
        head = head.getNext();
        size--;
    }
    else if(isEmpty())
    {
        System.out.println("empty stack");

    }

     return  head;

}