int maxNumberOfConsecutiveBits(BitSet bs) {
    int maxLength = 0;
    int onesI = bs.length(); // Points to the prior 0.
    for (int i = onesI; (i = bs.previousClearBit(i - 1)) >= 0; ) {
        int length = onesI - 1 - i;
        maxLength = Math.max(maxLength, length);
        i = bs.previousSetBit(i - 1) + 1; // Heuristic, optional.
        onesI = i;
    }
    return maxLength;
}