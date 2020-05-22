public myNodes searchByCode(String e1) //Assuming you have a single occurrence of code in your list, otherwise, it returns the last occurrence
{
    myNodes tmp, retVal = null;
    for(tmp=head; tmp!=null; tmp=tmp.next)
    {
      if (e1.equalsIgnoreCase(tmp.getCode()))
        {
            retVal = tmp;
        }
    }
    return retVal
}