ArrayList<String> al = new ArrayList<String>();
    al.add("2015/11/01 12.12.12.990");
    al.add("2015/11/01 12.12.12.992");
    al.add("2015/11/01 12.12.12.999");
    al.add("2015/11/01 12.12.15.135");
    al.add("2015/11/01 12.12.15.995");
    al.add("2015/11/01 12.12.20.135");
    al.add("2015/11/01 12.12.20.200");
    al.add("2015/11/01 12.12.20.300");
    al.add("2015/11/01 12.12.20.900");

    HashMap<String, Integer> hash = new HashMap<>();
    int count = 0;
    for(int i=0;i<al.size();i++){
        if(i>0 && al.get(i).substring(0, 19).equalsIgnoreCase(al.get(i-1).substring(0, 19)))
            hash.put(al.get(i).substring(0, 19),++count);
        else
            hash.put(al.get(i).substring(0, 19),count=1);
    }
    for (Entry<String, Integer> entry : hash.entrySet()) {
        System.out.println(entry.getKey()+","+entry.getValue());
    }