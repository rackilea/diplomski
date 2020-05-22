int maxLenght = 0;
    for (int i = 0; i < array.length; i++) {
        maxLenght = Math.max(maxLenght, array[i].length);
    }
    maxLenght = Math.max(maxLenght, array.length);
    for (int i = 0; i < maxLenght; i++) {
        int oneCountRow = 0;
        int oneCountColumn = 0;
        for (int j = 0; j < maxLenght; j++) {
            if (j < array[i].length && i < array.length && array[i][j] == 1) {
                oneCountRow++;
            }
            if (i < array[j].length && j < array.length && array[j][i] == 1) {
                oneCountColumn++;
        }

        System.out.println("Row " + (i + 1) + ": " + (oneCountRow > 5));
        System.out.println("Column " + (i + 1) + ": " + (oneCountColumn> 5));
}