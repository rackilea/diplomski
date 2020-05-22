List<Integer> mylist = new ArrayList<Integer>();
    mylist.add(3);
    mylist.add(3);


    HashSet hs = new HashSet();
    hs.addAll(mylist);
    mylist.clear();
    mylist.addAll(hs); 

    System.out.println(mylist.size()); //prints 1
    System.out.println(hs.size());// prints 1