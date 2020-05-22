for (Iterator<Tuple> it = list.iterator(); it.hasNext();) 
{
       Tuple tA = it.next();
       List<Tuple> tmpList = new ArrayList<Tuple>(list);
       tmpList.remove(tA);
  for( Iterator<Tuple> it2 = tmpList.iterator(); it2.hasNext();)     {
        try{
            Tuple tB=it2.next();

            if(tA.Username.equals(tB.Username) && .....)
            {
                System.out.println("Match");
            }
            else
            {
                System.out.println("Not Matched");
            }
            i++;
        }
        catch(NoSuchElementException exc)
        {
            throw exc;
        }   
    }
}