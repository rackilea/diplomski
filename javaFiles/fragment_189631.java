List<Integer> list1 = Arrays.asList(1, 4, 3, 5, 6, 9, 4, 1, ...);
List<Integer> list2 = Arrays.asList(1, 0, 3, 0, 0, 9, 4, 0, ...);

IntStream.range(0, list1.size())
    .mapToObj(i -> list1.get(i).equals(list2.get(i)) ? list1.get(i) : null)
    .filter(Objects::nonNull).collect(Collectors.toList());