Map<Integer, List<Integer>> sorted = 
    map.entrySet()
       .stream()
       .sorted(comparing(e -> ex.get(e.getKey()), reverseOrder()))
       .collect(toMap(
           Map.Entry::getKey,
           e -> e.getValue().stream().sorted(comparing(ex::get, reverseOrder())).collect(toList()),
           (v1, v2) -> { throw new IllegalStateException(); },
           LinkedHashMap::new
       ));