public int findSingleNumber(int[] array) {
    int result = 0;
    for (int item : array) {
        result ^= item;
    }
    return result;
}