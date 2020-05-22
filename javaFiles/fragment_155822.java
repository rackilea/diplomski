int count = 0;
 ArrayList<String> b = new ArrayList<>();
 while((x.hasNext()))
    {
        String a = x.next();
        if(!b.contains(a)){
           b.add(a);
        }
        count++;
    }