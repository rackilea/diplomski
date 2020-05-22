int rows = 4; // this is the value that the user will enter for # of rows

for (int i = rows; i > 0; i--) {
    for (int j = rows; j > 0; j--)
        System.out.print((rows - j + 1) < i ? "   " : String.format("%3d", j * j));
    System.out.println();
}