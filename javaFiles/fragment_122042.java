Map<Integer,String> forwardMap = new HashMap<>();
Map<String,Set<Integer>> reverseMap = new HashMap<>();

void add(Integer x, String y) {
    forwardMap.put(x, y);
    if (!reverseMap.containsKey(y))
        reverseMap.put(y, new HashSet<Integer>());
    reverseMap.get(y).add(x);
}