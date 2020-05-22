Map<String, List<String>> mapList = new HashMap<String, List<String>>();

  // fill map here...

  for (String key : mapList.keySet()) {
     List<String> list = mapList.get(key);

     System.out.printf("%s: %s%n", key, list);
  }