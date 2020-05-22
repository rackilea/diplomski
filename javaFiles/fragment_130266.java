static BitSet fromInt(int num) {
    BitSet bs = new BitSet();
    for (int k = 0; k < Integer.SIZE; k++) {
        if (((num >> k) & 1) == 1) {
            bs.set(k);
        }
    }
    return bs;
}