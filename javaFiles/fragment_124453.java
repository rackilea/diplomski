long result = IntStream.range(0, nums.size())
    .flatMap(from -> IntStream.range(from + 1, nums.size() + 1)
        .map(to -> nums.subList(from, to).stream()
            .mapToInt(i -> i)
            .sum()))
    .filter(sum -> sum < 0)
    .count();