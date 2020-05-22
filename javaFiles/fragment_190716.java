Map<Integer, String> collect = mappy.entrySet().stream()
    .filter(map -> map.getKey() == 2)
    .peek(entry -> {
        randomObj.seti1(entry.getKey());
        randomObj.sets1(entry.getValue());
    })
    .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));