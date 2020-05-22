List<Car> cars =
    users.stream()
    .flatMap(user -> user.getCars().stream())
    .collect(Collectors.groupingBy(Car::getCode,
        Collectors.mapping(Car::getFeatures, Collector.of(
            ArrayList<Feature>::new, List::addAll, (a,b)->{a.addAll(b);return a;}))))
    .entrySet().stream()
    .map(e -> new Car(e.getKey(), e.getValue()))
    .collect(Collectors.toList());