Map<String, List<String>> map = new HashMap<>();
for (String str : result) {
    String[] spl = str.split("\\.");//Split each string with dot(.)
    if (!map.containsKey(spl[0])) {//If the map not contains this key (left part)
        map.put(spl[0], new ArrayList<>(Arrays.asList(spl[1])));//then add a new node
    } else {
        map.get(spl[0]).add(spl[1]);//else add to the list the right part
    }
}