HashMap<String, String> map = new HashMap<>();
map.put("s","");
map.put("not empty", "not empty");

Map<String, String> notEmtpy = map.entrySet().stream()
     .filter(e -> !e.getValue().isEmpty())
     .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));