public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
    if (randomNumberOrigin >= randomNumberBound)
        throw new IllegalArgumentException(BadRange);
    return StreamSupport.intStream
            (new RandomIntsSpliterator
                     (this, 0L, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound),
             false);
}