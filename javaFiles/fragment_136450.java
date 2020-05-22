Map<String, Double> map = new HashMap<String, Double>();
map.put("1.1", 1.1);
map.put("0.1", 0.1);
map.put("2.1", 2.1);

Double min = Collections.min(map.values());
System.out.println(min); // 0.1