Map< String, List< String>> map = new HashMap<>();

    List<String> list = map.get(s1);
    if(list == null){
      list = new LinkedList<>();
      map.put(s1,list);
    }
    list.add(s2);