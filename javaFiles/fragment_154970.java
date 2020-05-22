NavigableMap<Double,String> map = new TreeMap<>();
map.put(0.5, "a");
map.put(1.1, "b");
map.put(1.8, "c");

System.out.println(map.ceilingEntry(1.6).getValue());  // shows "c"