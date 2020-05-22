for (int i = 0; i < myStringArray.length(); i++)
{
    if (myStringArray[i].equals(stringToRemove))
    {
        myStringArray[i] = null;
        break;
    }
}