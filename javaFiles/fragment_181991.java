Map<Integer, String> map = new HashMap<Integer, String>();
map.put(1, "x");
map.put(2, "y");
map.put(2, "z");
map.put(3, "x");
map.put(4, "y");
map.put(5, "z");
map.put(6, "x");
map.put(7, "y");

System.out.println("Original map: " + map);

Multimap<String, Integer> multiMap = HashMultimap.create();
for (Entry<Integer, String> entry : map.entrySet()) {
  multiMap.put(entry.getValue(), entry.getKey());
}
System.out.println();

for (Entry<String, Collection<Integer>> entry : multiMap.asMap().entrySet()) {
  System.out.println("Original value: " + entry.getKey() + " was mapped to keys: "
      + entry.getValue());
}