public Object removeLast()
{
    Node currentNode;
    currentNode = this.getHead();
    while(currentNode != null)
    {

        if(currentNode.getNext()==null)
        {
           // The line below is changed!!!
           currentNode.getPrevious().setNext(null);
           return null;
        }
        currentNode = currentNode.getNext();
    }
    return null;
}