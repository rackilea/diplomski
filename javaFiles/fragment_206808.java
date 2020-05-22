static void split(List<Rank> rankList) {
    List<Rank> sorted = rankList.stream()
        .distinct()
        .sorted()
        .collect(toList());

    List<Integer> splits = IntStream.range(1, sorted.size())
        .filter(i -> sorted.get(i).ordinal() != sorted.get(i-1).ordinal() + 1)
        .boxed()
        .collect(toCollection(ArrayList::new));

    splits.add(0, 0);
    splits.add(sorted.size());

    List<List<Rank>> runs = IntStream.range(1, splits.size())
        .mapToObj(i -> sorted.subList(splits.get(i-1), splits.get(i)))
        .collect(toList());

    int longest = runs.stream()
        .mapToInt(list -> list.size())
        .max()
        .getAsInt();

    runs.stream()
        .filter(list -> list.size() == longest)
        .forEach(System.out::println);
}