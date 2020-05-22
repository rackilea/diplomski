//Some Pseudo Code
Entry current = head;
Entry last = null;
while(Not Done Looping)
{
    Entry temp = current.getNext();
    if(temp is not null) //We have a reference to another element
    {
        //We have more list to see
        current = temp;
    }
    else
        last = current;
}