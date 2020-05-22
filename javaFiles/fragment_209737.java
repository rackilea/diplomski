public boolean editNode(String searchValue, String newValue)
{
    boolean success = False;
    myNodes tmp = searchByCode(searchValue);
    if (tmp != Null) //It would be better to use exceptions
    {
        tmp.setName(newValue); //I'm assuming you have getters and setters. and of course you could do anything else in here
        success = True;
    }
    return success;
}