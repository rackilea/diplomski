private static final Map<String, String> expectedMap;
static {
    Map<String, String> aMap = new HashMap<>();
    aMap.put("x", "1");
    aMap.put("y", "2");
    aMap.put("z", "3");
    expectedMap = Collections.unmodifiableMap(aMap);
}