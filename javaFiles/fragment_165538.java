String[] str = {"Sam", "Mohit", "Laksh", "Nitesh"};
    List<String> list = new ArrayList<String>();
    for(int i=0;i<str.length;i++)
    {
       list.add(str[i]);
    }

    Iterator<String> iter = list.iterator();
    while(iter.hasNext()){
        //here apply some condition to get your specific string object
        char[] chars = iter.next().toCharArray();
        System.out.println(chars);
    }