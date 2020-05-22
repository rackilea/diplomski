public static void printChristmasTree(int height, char ch) {
    if (height <= 4)
        throw new IllegalArgumentException("Height must be 5 or higher");
    for (int row = height; row > 0; row--) {
        int spaces = (row > 2 ? row - 3 : height - 4);
        int fill = (height - spaces) * 2 - 5;
        System.out.printf("%2d|%s%s%s|%d=%d+%d+%d%n", row,
                          repeat(spaces, ' '), repeat(fill, ch), repeat(spaces, ' '),
                          spaces * 2 + fill, spaces, fill, spaces);
    }
}
private static String repeat(int count, char ch) {
    char[] buf = new char[count];
    java.util.Arrays.fill(buf, ch);
    return new String(buf);
}