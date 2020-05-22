String key = "someKey";
String value1 = "someValue1";
String value2 = "someValue2";

Map<String, List<String>> map2 = new HashMap<>();
map2.computeIfAbsent(key, k -> new ArrayList<>()).add(value1);
map2.computeIfAbsent(key, k -> new ArrayList<>()).add(value2);
System.out.println(map2);