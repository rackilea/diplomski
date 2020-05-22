List<Map> list = new ArrayList<>();
for(Map.Entry<String, Integer> entry : hashes.entrySet()) {
    Map newMap = new HashMap();
    newMap.put("name", entry.getKey());
    newMap.put("attributes", entry.getValue());

    list.add(newMap);
}