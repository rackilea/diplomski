List<Car> cars =
    users.stream()
    .flatMap(user -> user.getCars().stream())
    .collect(Collectors.groupingBy(Car::getCode,
        Collectors.mapping(Car::getFeatures, Collector.of(
            LinkedHashSet<Feature>::new, Set::addAll, (a,b)->{a.addAll(b);return a;}))))
    .entrySet().stream()
    .map(e -> new Car(e.getKey(), new ArrayList<>(e.getValue())))
    .collect(Collectors.toList());