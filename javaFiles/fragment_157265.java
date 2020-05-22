Map<String, Integer> innerMap = outerMap.get(outerKey);
if (innerMap == null) {
    innerMap = new HashMap<>();
    outerMap.put(outerKey, innerMap);
}
innerMap.put(innerKey, value);