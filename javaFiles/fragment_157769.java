List<Integer> list = Arrays.asList(1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 4);

Map<Integer, Long> countGrouped = list.stream().collect(
    Collectors.groupingBy(x -> x, Collectors.counting()));
System.out.println("group by value, count " + countGrouped);

Map<Long, List<Integer>> groups = countGrouped.entrySet().stream()
    .filter(x -> x.getValue() >= 2)
    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
    .collect(Collectors.groupingBy(Map.Entry::getValue, LinkedHashMap::new, 
        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

System.out.println("grouped " + groups);