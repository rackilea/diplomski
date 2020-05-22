public IntStream ints(long streamSize, int randomNumberOrigin,
                      int randomNumberBound) {
    if (streamSize < 0L)
        throw new IllegalArgumentException(BadSize);
    if (randomNumberOrigin >= randomNumberBound)
        throw new IllegalArgumentException(BadRange);
    return StreamSupport.intStream
            (new RandomIntsSpliterator
                     (this, 0L, streamSize, randomNumberOrigin, randomNumberBound),
             false);
}