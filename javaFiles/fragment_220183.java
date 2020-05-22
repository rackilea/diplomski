ArrayList <String> s = new ArrayList<String> (4); 
    s.add("A");
    s.add("B");
    s.add("C");
    s.add("D");

    //reverse the arraylist
    Collections.sort(s ,Collections.reverseOrder());
    Iterator<String> i = s.iterator();

    while(i.hasNext()){
        System.out.println(i.next());
        i.remove();
    }