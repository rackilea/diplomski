public static String binaryCode(int i) {
    if (i <= 1) {
        return "" + i%2;
    }
    return "" + i%2 + binaryCode(i/2);
}