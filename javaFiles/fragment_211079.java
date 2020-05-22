public int nextSetBit(int fromIndex) {
    if (fromIndex < 0)
        throw new IndexOutOfBoundsException("fromIndex < 0: " + fromIndex);

    checkInvariants();

    int u = wordIndex(fromIndex);
    if (u >= wordsInUse)
        return -1;

    long word = words[u] & (WORD_MASK << fromIndex);

    while (true) {
        if (word != 0)
            return (u * BITS_PER_WORD) + Long.numberOfTrailingZeros(word);
        if (++u == wordsInUse)
            return -1;
        word = words[u];
    }
}