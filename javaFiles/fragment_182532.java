public static List<Fruit> buildFinalList(List<Fruit> firstList, List<Fruit> secondList) {
    Map<String, Fruit> map = secondList.stream().collect(Collectors.toMap(Fruit::getId, Function.identity()));

    List<Fruit> finalList = firstList.stream()
                                     .filter(fruit -> map.containsKey(fruit.getId()))
                                     .map(fruit -> map.get(fruit.getId()))
                                     .collect(Collectors.toList());
    firstList.stream()
             .filter(fruit -> !map.containsKey(fruit.getId()))
             .forEach(finalList::add);

    return finalList;
}