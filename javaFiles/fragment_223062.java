Set<String> exclude =  new HashSet<String>(Arrays.asList("a","b","c"));
 for(String s : testStringArray)
    {
      if(!exclude.contains(s)){
          joinString.add(s);
       }
  }