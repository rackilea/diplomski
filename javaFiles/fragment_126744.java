for (String key : map1.keySet()) {    
  if (!map2.containsKey(key)) {
    System.out.println(key + "has been removed from Array2" )
  } else if (!map1.get(key).equals(map2.get(key)) {
    System.out.println(key + "attribute has changed from " + map1.get(key) + " to " + map2.get(key)  );
  } 
}