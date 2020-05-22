public static boolean sameNumbers(int[] values1, int[] values2) {
    values1 = IntStream.of(values1).sorted().distinct().toArray();
    values2 = IntStream.of(values2).sorted().distinct().toArray();
    if (values1.length != values2.length) {
        return false;
    }
    for (int i = 0; i < values1.length; ++i) {
        if (values1[i] != values2[i]) {
            return false;
        }
    }
    return true;
}