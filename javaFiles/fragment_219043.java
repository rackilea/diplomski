Map<Integer, DateTime> map =
    list2.stream()
         .collect(groupingBy(
             Entry::getId,
             collectingAndThen(maxBy(comparing(Entry::getDate)), e -> e.get().getDate())
         ));

Map<Integer, Long> mapCount2 = list2.stream().collect(groupingBy(Entry::getId, counting()));
Map<Integer, Long> mapCount1 = list1.stream().collect(groupingBy(Entry::getId, counting()));