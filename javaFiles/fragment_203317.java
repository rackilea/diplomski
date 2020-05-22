Map<String, Integer> map = new HashMap<String, Integer>();

if (map.containsKey(input)) {
    map.put(input, map.get(input) + 1);
} else {
    map.put(input, 1);
}