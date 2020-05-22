public static LongStream primes() {
    return LongStream.iterate(2L,
        prev -> prev == 2 ? 3 : 
                prev == 3 ? 5 :
                LongStream.iterate(prev + 1, i -> i + 1)
                        .filter(x -> Seq.seq(primes())
                            .limitWhile(p -> p <= Math.sqrt(x))
                            .allMatch(p -> x % p != 0)
                        ).findFirst()
                        .getAsLong());