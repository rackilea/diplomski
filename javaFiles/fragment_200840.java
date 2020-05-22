static LongStream factors(long lastFactor, long num) {
    return LongStream.rangeClosed(lastFactor, (long) Math.sqrt(num))
            .filter(x -> num % x == 0)
            .mapToObj(x -> LongStream.concat(LongStream.of(x), factors(x, num / x)))
            .findFirst()
            .orElse(LongStream.of(num));
}