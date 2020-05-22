Map<String, Integer> map = new LinkedHashMap(10, 0.75, true);
map.put("foo", 1); map.put("bar", 2);
System.out.println(map.keySet().iterator().next()); // prints "bar"
map.put("foo", 1); 
System.out.println(map.keySet().iterator().next()); // prints "foo"
map.get("bar");
System.out.println(map.keySet().iterator().next()); // prints "bar"