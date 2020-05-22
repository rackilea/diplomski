LinkedList list = //Get/build your list

public void doStuffToList()
{
    synchronized(list)
    {
        //Do things to the list
    }
}

public void clearList()
{
    synchronized(list)
    {
        list.clear();
    }
}