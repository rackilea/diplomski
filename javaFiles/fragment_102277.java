List<Integer> list = IntStream.range(0, 10000).boxed().collect(Collectors.toList());
Map<Integer, Integer> map = new HashMap<>();
list.parallelStream().forEach(i -> {
    map.put(i, i);
});
System.out.println(list.size());
System.out.println(map.size());