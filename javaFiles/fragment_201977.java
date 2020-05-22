List<String> commonValues = myMap.values().stream()
    .reduce(null, (a, b) -> {
        if(a == null) return new ArrayList<>(b);
        a.retainAll(b);
        return a;
    });