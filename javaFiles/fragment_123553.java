public static void printChristmasTree(int height, char ch) {
    final int trunkHeight = (height + 2) / 4; // rounded
    final int treeWidth = (height - trunkHeight) * 2 - 1;
    final int width = (treeWidth > 3 || trunkHeight == 0 ? treeWidth : 3);
    for (int row = height; row > 0; row--) {
        int fill = (row > trunkHeight ? (height - row) * 2 + 1 : 3);
        int spaces = (width - fill) / 2;
        System.out.printf("%2d|%s%s%s|%d=%d+%d+%d%n", row,
                          repeat(spaces, ' '), repeat(fill, ch), repeat(spaces, ' '),
                          spaces * 2 + fill, spaces, fill, spaces);
    }
}