Map<String, String> map = new HashMap<String, String>();
map.put("Foo", "Bar");

System.out.println(map.keySet().size()); // 1
System.out.println(map.values().size()); // 1

map.put("Foo", "Baz"); // the HashMap will merely replace the old value

System.out.println(map.keySet().size()); // still 1
System.out.println(map.values().size()); // still 1