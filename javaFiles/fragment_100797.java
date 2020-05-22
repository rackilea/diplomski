Map<String, List<Person>> langPersons =
    people.stream()
          .flatMap(p -> p.getLanguagesSpoken()
                         .stream()
                         .map(l -> new SimpleEntry<>(l,p)))
          .collect(Collectors.groupingBy(Map.Entry::getKey,
                                         Collectors.mapping(Map.Entry::getValue,
                                                            Collectors.toList())));