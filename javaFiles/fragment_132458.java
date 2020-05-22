public static int countNeg(int x[][]) {
    long count = Stream.of(x)
            .flatMapToInt(arr -> IntStream.of(arr))
            .filter(i -> i < 0)
            .count();
    return Math.toIntExact(count);
}