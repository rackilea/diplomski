ArrayList<ArrayList<Arc>> rotalar1 = new ArrayList<ArrayList<Arc>>();
    ArrayList<ArrayList<Arc>> rotalar2 = new ArrayList<ArrayList<Arc>>();

    for(ArrayList<Arc> list : rotalar1)
    {
        ArrayList<Arc> tmpList = new ArrayList<>();
        for(Arc arcObj : list)
        {
            tmpList.add(copyOfyourArc); //TODO how do you want to creat a copy of Arc obj?
        }
        rotalar2.add(tmpList);
    }