for (int i = 0; i < 10; i++) {
    int oneCountRow = 0;
    int oneCountColumn = 0;
    for (int j = 0; j < 10; j++) {
        if (array[i][j] == 1) {
            oneCountRow++;
        }
        if (array[j][i] == 1) {
            oneCountColumn++;
        }
    }

    System.out.println("Row " + (i + 1) + ": " + (oneCountRow > 5));
    System.out.println("Column " + (i + 1) + ": " + (oneCountColumn> 5));
}