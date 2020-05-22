IntStream factors(int num) {
    return IntStream.range(2, num)
        .filter(x -> num % x == 0)
        .mapToObj(x -> IntStream.concat(IntStream.of(x), factors(num / x)))
        .findFirst()
        .orElse(IntStream.of(num));
}