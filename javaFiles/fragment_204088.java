private static void gen(int index, int minI) {
    if (index == result.length) {
        printArray();
        return;
    }
    for (int i = minI; i <= n; i++) {
        result[index] = i;
        gen(index + 1, i);
    }
}