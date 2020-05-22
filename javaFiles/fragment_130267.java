static int toInt(BitSet bs) {
    int num = 0;
    for (int k = -1; (k = bs.nextSetBit(k + 1)) != -1; ) {
        num |= (1 << k);
    }
    return num;
}