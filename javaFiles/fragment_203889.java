Map<Animal, List<Farm>> map = list.stream()
    .flatMap(farm -> farm.getAnimals().stream()
        .map(animal -> new AbstractMap.SimpleImmutableEntry<>(animal, farm)))
    .collect(Collectors.groupingBy(Map.Entry::getKey,
        () -> new EnumMap<>(Animal.class),
        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));