public Map<String, String> invertedMap(Map<String, List<String>> map) {
    Map<String, String> inverted = new HashMap<>();
    for (Entry<String, List<String>> e : map.entrySet())
        for (String city : e.getValue())
            inverted.put(city, e.getKey() /* state */);
    return inverted;
}