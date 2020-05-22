Map<String, Map<String, String>> map = new HashMap<>();

Map<String, String> value1 = new HashMap<>();
value1.put("1", "2");
value1.put("3", "4");
value1.put("5", "6");
map.put("1", value1);

Map<String, String> value2 = new HashMap<>();
value2.put("1", "2");
value2.put("3", "4");
value2.put("5", "6");
map.put("2", value2);

System.out.println(map);