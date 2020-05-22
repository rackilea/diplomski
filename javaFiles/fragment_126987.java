Map<String, String> aMap = new HashMap<>();
aMap.put("somekey", null);

aMapList.add(aMap);

aMapList.straem()
    .filter(a -> a.contains("somekey")) // true returned for contains
    .map(a -> a.get("somekey")) // null returned for get
    .collect(Collectors.toList());