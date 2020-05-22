public static Map<String, List<String>> getMap(List<String> list) {
    Map<String, List<String>> map = new HashMap<>();

    for (String s: list) {
        if (!map.containsKey(s)) {
            List<String> mapList = new ArrayList<>();
            mapList.add(s);
            map.put(s, mapList);
        } else {
            ((List<String>)map.get(s)).add(s);
        }
    } 
    return map;
}