List<String> commonValues = myMap.values().stream()
    .reduce((a, b) -> {
        a.retainAll(b);
        return a;
    })
    .orElse(Collections.emptyList());