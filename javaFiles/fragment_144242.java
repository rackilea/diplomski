public static void getMeNumbersWithHighestFrequence3(int[] numbers, int howMany) {

    Map<Integer, Long> collect = IntStream.of(numbers).boxed().collect(groupingBy(Function.identity(), TreeMap::new, counting())).descendingMap().entrySet().stream()
            .limit(howMany)
            .collect(TreeMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);

}