// a list to test with
List<String> list = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));

List<String> list2 = list.stream()
   .sorted(Comparator.comparing(x -> list.indexOf(x) % 2).thenComparing(x -> list.indexOf(x)))
   .collect(Collectors.toList());
list2.forEach(System.out::print);