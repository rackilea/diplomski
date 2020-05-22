public class Main {
    public static <T> Stream<T> cartesian(BinaryOperator<T> aggregator, Supplier<Stream<T>>... streams) {
        return  Arrays.stream(streams)
                .reduce((s1, s2) ->
                        () -> s1.get().flatMap(t1 -> s2.get().map(t2 -> aggregator.apply(t1, t2))))
                .orElse(Stream::empty).get();
    }

public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);

        Stream<String> result = cartesian((a, b) -> a + b, () -> Stream.of(""), () -> Stream.of(""));
        for (Integer curI : list) {
            Stream<String> resultInner = result;
            result = cartesian(
                    (a, b) -> a + b,
                    () -> cartesian(
                            (a, b) -> a + b,
                            () -> resultInner,
                            () -> IntStream.rangeClosed(1, curI).mapToObj(c -> String.valueOf(c) + ", ")
                    )
            );
        }
        result.forEach(System.out::println);
    }
}