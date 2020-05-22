List<List<Integer> > list =  new ArrayList<List<Integer> >(n);
    for(int i=0;i<n;i++)
    {
        list.add(new ArrayList<Integer>());
    }

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<10;j++)
        {
            list.get(i).add(j);
        }
    }
    System.out.println(list);