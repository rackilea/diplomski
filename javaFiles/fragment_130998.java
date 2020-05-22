// intermediate list of sums
List<Integer> sums = kidsL.stream()
        .mapToInt(a -> Arrays.stream(a).flatMapToInt(Arrays::stream).sum())
        .boxed().collect(Collectors.toList());

sums.stream().mapToInt(i -> i)
        .min()
        .ifPresent(System.err::println);

sums.stream().mapToInt(i -> i)
        .max()
        .ifPresent(System.err::println);