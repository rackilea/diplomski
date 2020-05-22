for(ArrayList<Arc> list : rotalar1)
    {
        ArrayList<Arc> copy = new ArrayList<>();
        Collections.copy(copy, list);  //or copy.addAll(list);
        rotalar2.add(copy);
    }