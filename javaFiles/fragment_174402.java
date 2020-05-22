private static void printTriangle(int k) {
    for (int i = 1; i <= k; i++) {
        printSpaces(k - i);
        printStars(i);
    }
}