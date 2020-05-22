private static void addIntern(Map<String, Map<String, String>> internalMap, String val2, Integer val1, String val3,
        String val4, String type, String id) {
    String key = id + "##" + val4;
    Map<String, String> kMap;
    if (internalMap.containsKey(key)) {
        kMap = internalMap.get(key);
    } else {
        kMap = new HashMap<>();
        internalMap.put(key, kMap);
    }
    kMap.put("val3", val3);
    kMap.put("val2", val2);
    if ("create".equals(type) || "update".equals(type) || "delete".equals(type)) {
        kMap.put(type, val1.toString());
    }
}