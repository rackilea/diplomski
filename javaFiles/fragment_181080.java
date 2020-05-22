current = current.getNext();

if(current.getData().equals(temp.getData()))
{
    if(found == true)
    {
        // remove element
        current.setNext(current.getNext().getNext()); // this isn't actually removing 'current'...
        listCount--;
        break;
    }
    else if(found == false)
    {
        found = true;
    }

}