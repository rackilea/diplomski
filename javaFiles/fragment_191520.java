List<Fruit> genericFruitList = fruits
    .collect(Collectors.groupingBy(fruit -> fruit.getName()))
    .entrySet().stream()
    .sorted(Map.Entry.comparingByKey(comp))
    .flatMap(e -> e.getValue().stream())
    .collect(Collectors.toList());