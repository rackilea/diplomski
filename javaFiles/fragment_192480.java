HashMap<String, Integer> map = new HashMap<String, Integer> ();

    map.put("Login to new", 27);
    map.put("Failed login", 27);
    map.put("Impossible", 21);

  List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
   Collections.sort(list, new MapValueKeyComparator<String, Integer>());

  for(Map.Entry<String, Integer> m : list){
     System.out.println(m);
  }