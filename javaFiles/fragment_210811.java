list.stream()
    .flatMap(person -> person.getInternals()
                       .stream()
                       .map(internal -> 
                           Pair.of(person.getName() + internal.getKey(), internal.getValue()))
    .collect(Collectors.toMap(Pair::getLeft, Pair::getRight));