for (String key : h.keySet())
{
    if(h.get(key).size() == 0)
    {
         System.out.println("There is no errors in " + key) ;
    }
    else
    {
        System.out.println("ERROR: there are unexpected errors in " + key);
    }
}