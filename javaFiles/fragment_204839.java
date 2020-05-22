Map<Integer, String> map = new HashMap<>();
map.put(1, "B");
map.put(2, "C");
map.put(3, "A");

for(Map.Entry<Integer, String> entry : sortByValues(map).entrySet()) {
  System.out.println(entry.getKey()+" : "+ entry.getValue());
}