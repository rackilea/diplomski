Map<String, Set<Integer>> map = new HashMap<>();
// fill map here
String result = map.entrySet().stream()
        .map(x -> x.getKey() + ": " + x.getValue().stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")))
        .collect(Collectors.joining("; "));