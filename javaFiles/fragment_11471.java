TreeSet ts=new TreeSet();
    for (int i=0;i<words.length;i++)
    {
        ts.add(words[i]+"-|-"+definitions[i]+"-|-"+notes[i]);
    }
    Iterator<String> itr=ts.iterator();
    while(itr.hasNext()){
        System.out.println(itr.next());
    }