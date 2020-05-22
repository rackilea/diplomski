int maxNumberOfConsecutiveBits(BitSet bitSet) {
    int maxLength = 0;
    BitSet bs = bitSet.clone();
    while (!bs.isEmpty()) {
        ++maxLength;
        BitSet bs2 = shiftOne(bs);
        bs.and(bs2);
    }
    return maxLength;
}