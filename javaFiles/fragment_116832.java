Map<String, Map<String, String>> myMap = new HashMap<>();
Map<String, String> inner = new HashMap<>();
inner.put("one", "two");
myMap.put("three", inner);
System.out.println(method(myMap, "three", "one"));
System.out.println(method(myMap, "three", "dne"));
System.out.println(method(myMap, "dne", "dne"));