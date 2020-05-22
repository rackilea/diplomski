Map<String, Integer> oldMap = new TreeMap<>();
Map<String, Integer> newMap = new TreeMap<>();

oldMap.put("1", 10);
oldMap.put("2", 5);
newMap.put("1", 7);

oldMap.forEach((k, v) -> newMap.merge(k, v, (a, b) -> a + b));

System.out.println(newMap); //{1=17, 2=5}