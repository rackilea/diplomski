private static <T> Stream<List<T>> product(Stream<T>... streams) {
    if (streams.length == 0) {
        return Stream.empty();
    }
    List<List<T>> cartesian = streams[streams.length - 1].map(x -> Collections.singletonList(x)).collect(Collectors.toList());
    for (int i = streams.length - 2; i >= 0; i--) {
        final List<List<T>> previous = cartesian;
        cartesian = streams[i].flatMap(x -> previous.stream().map(p -> {
            final List<T> list = new ArrayList<T>(p.size() + 1);
            list.add(x);
            list.addAll(p);
            return list;
        })).collect(Collectors.toList());
    }
    return cartesian.stream();
}

public static void main(String... args) {
    final Stream<List<String>> result =
            product(
                    Stream.of("A", "B", "C", "D"),
                    Stream.of("I", "J", "K"),
                    Stream.of("Y", "Z")
            );

    result.forEach(System.out::println);
}