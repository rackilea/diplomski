System.out.println(
    Stream.empty().collect(Collectors.partitioningBy(a -> false)));
// Output: {false=[], true=[]}

System.out.println(
    Stream.empty().collect(Collectors.groupingBy(a -> false)));
// Output: {}