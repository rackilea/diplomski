map.entrySet()
   .stream() // build a Stream<Map.Entry<Integer,String> of all the map entries
   .filter(e -> e.getValue().equals("test2")) // locate entries having the required value
   .map(Map.Entry::getKey) // map to the corresponding key
   .findFirst() // get the first match (there may be multiple matches)
   .orElse(null); // default value in case of no match