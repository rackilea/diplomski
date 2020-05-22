if(userID.trim().isEmpty())//trim removes whitespaces 
{
    throw new SomeKindOfException();
    //or just ...
    return; 
}