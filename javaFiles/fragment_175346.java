Map<String, List<Pair<Integer, Integer>>> map = new HashMap<>();
// ...
map.putIfAbsent(key, new ArrayList<>());

if (!map.get(key).contains(mPair)) {
    map.get(key).add(mPair);
}

// probably should optimize this to get rid of the multiple calls to map.get(key)