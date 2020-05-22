private Node<T> getNth(int index)
{
    Node<T> temp = null; //Always try to initialize your variables if you're going
                         //to return them.
    if(index < 0 || index > size)
        throw new IndexOutOfBoundsException();

    if(index < this.size() / 2)
    {
        temp = this.head;
        for(int i = 0; i < index; i++)
        {
            if(temp.getNext() != null)
                 temp = temp.getNext();
            else
                 break;//Break the iteration if there is not a next node
        }
    }
    else
    {
        temp = this.tail;
        for(int i = this.size(); i > index; i--)
        {
            if(temp.getPrev() != null)
                temp = temp.getPrev();
            else
                break;
        }
    }
    return temp;
}