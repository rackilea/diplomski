List<Pair<String, String>> result =
    map.entrySet()
       .stream()
       .flatMap(
           entry -> entry.getValue()
                         .stream()
                         .map(string -> new Pair<>(entry.getKey(), string)))
       .collect(Collectors.toList());