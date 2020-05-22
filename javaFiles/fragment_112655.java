public static boolean sameNumbers(int[] values1, int[] values2) {
    Arrays.sort(values1);
    Arrays.sort(values2);
    int i1 = 0;
    int i2 = 0;
    while (i1 < values1.length && i2 < values2.length) {
        if (values1[i1++] != values2[i2++]) {
            return false;
        }
        while (values1[i1] == values1[i1 - 1] { // Repetitions in values1
            ++i1;
        }
        while (values1[i2] == values1[i2 - 1] { // Repetitions in values1
            ++i2;
        }
    }
    return i1 == values1.length && i2 == values2.length;
}