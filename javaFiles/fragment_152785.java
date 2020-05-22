Set<Integer> keepThese = new HashSet<Integer>();

    for (int x : sel)
    {
      keepThese.add(x);
    }

    for (int i=0 ; i<firstList.size() ; i++)
    {
       if(keepThese.contains(i))
            continue;

       else
       {
         if(secondList.contains(firstList.get(i)))
           continue;

         else
          secondList.add(firstList.get(i));

       }

  }