public void removeSecondAppear(Object data)
{
    Node temp = new Node(data);
    Node current = head;
    Node previous = null;

    boolean found = false;

    while(current != null)
    {

        // for the sake of argument, let's say this will return true if you find equal data
        if( current.getData() != null && current.getData().equals(temp.getData()))
        {
            if(found)
            {
                // remove element
                previous.setNext(current.getNext());
                listCount--;
                break;
            }
            else
            {
                found = true;
            }

        }
        else {
            found = false;
        }

        previous = current;
        current = current.getNext();
    }

}