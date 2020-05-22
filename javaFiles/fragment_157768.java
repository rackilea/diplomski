//Sort desc
Map<Integer, Long> descendingSorted = countGrouped.entrySet().stream()
    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
        (a,b) -> { throw new AssertionError(); }, LinkedHashMap::new));
System.out.println("sorted " + descendingSorted);

//filter
Map<Integer, Long> filtered = descendingSorted.entrySet().stream()
    .filter(x -> x.getValue() >= 2)
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
        (a,b) -> { throw new AssertionError(); }, LinkedHashMap::new));
System.out.println("filtered " + filtered);