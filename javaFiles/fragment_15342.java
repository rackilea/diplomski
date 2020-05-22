public static void countRecursive(int from, int to) {
    if (from <= to) {
        System.out.printf("%d ", from);
        countRecursive(from + 1, to);
    }
}