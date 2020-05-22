Map<String, Set<Map.Entry<String, String>>> map = new HashMap<>();

Set<Map.Entry<String, String>> value1 = new HashSet<>();
value1.add(new AbstractMap.SimpleEntry<>("1", "2"));
value1.add(new AbstractMap.SimpleEntry<>("3", "4"));
value1.add(new AbstractMap.SimpleEntry<>("5", "6"));
map.put("1", value1);

Set<Map.Entry<String, String>> value2 = new HashSet<>();
value2.add(new AbstractMap.SimpleEntry<>("1", "2"));
value2.add(new AbstractMap.SimpleEntry<>("3", "4"));
value2.add(new AbstractMap.SimpleEntry<>("5", "6"));
map.put("2", value2);

System.out.println(map);