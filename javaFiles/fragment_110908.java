ConcurrentHashMap<String, Integer> myMap = new ConcurrentHashMap<String, Integer>();

// some stuff

if (!myMap.contains("key")) {
  myMap.put("key", 3);
}