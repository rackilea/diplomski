List<Map<String, Integer>> listOfMaps = new ArrayList<Map<String, Integer>>();

for(int i = 0; i < 5; i++) {
   listOfMaps.add(new LinkedHashMap<String, Integer>());
}

listOfMaps.get(0).put("a", 0);
System.out.println(listOfMaps.get(0).get("a"));