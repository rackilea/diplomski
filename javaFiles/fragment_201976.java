List<String> commonValues = myMap.values().stream()
    .reduce((a, b) -> {
        List<String> c = new ArrayList<>(a);
        c.retainAll(b);
        return c;
    })
    .orElse(Collections.emptyList());