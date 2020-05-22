mapAB.entrySet().stream()
  .filter(e -> e.getValue().stream().anyMatch(mapBC::containsKey))
  .collect(toMap(
       Map.Entry::getKey,
       e->e.getValue().stream()
           .filter(mapBC::containsKey)
           .map(mapBC::get)
           .flatMap(Collection::stream)
           .collect(toList())
  ));