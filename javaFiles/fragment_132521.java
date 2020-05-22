@Override
public String toString()
{
    String myString = "";
    ListElement currentElement = head;
    while (currentElement.next != null)
    {
        if (myString.length > 0)
        {
            myString += ",";
        }
        myString += currentElement.value.toString();
        currentElement = currentElement.next;
    }
    return myString;
}