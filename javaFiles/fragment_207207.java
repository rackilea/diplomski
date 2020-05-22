List<Integer> keys = List.of(1,2);
List<String> values = 
    keys.stream()
        .map(map::get)
        .filter(Objects::nonNull) // get rid of null values
        .collect(Collectors.toList());