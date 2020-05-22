Map<String, String> map = new HashMap<>();
map.put("one",   "first value");
map.put("two",   "second value");
map.put("three", "third value");

System.out.println(Arrays.toString(map.entrySet().toArray()));