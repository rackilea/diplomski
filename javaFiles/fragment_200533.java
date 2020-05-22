public void add(int index, int e)
{
    DLink iterator=_firstLink;
    int count=0;
    while(iterator!=_lastLink)
    {
         if(count>=index)break;
         iterator=iterator._next;
         count++;
    }
    if(index==count)
    {
        DLink newLink = new DLink(e);
        newLink._previous=iterator._previous;
        newLink._next=iterator;
        iterator._previous=newLink;
    }
    else throw new Exception("IndexOutOfBoundException");
}