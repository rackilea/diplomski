Stream<String> lines = Stream.of("item1,16,2",
      "item2,17,3",
      "item1,16,5"); // sample input

Map<String, List<Integer>> map = lines.map(s -> s.split(","))
  .collect(Collectors.toMap(a -> a[0],
      a -> Arrays.asList(a).stream()
       .skip(1).map(Integer::parseInt)
        .collect(Collectors.toList()),
      (a, b) -> {for (int i = 0; i < a.size(); i++)
          a.set(i, a.get(i) + b.get(i)); return a;}));