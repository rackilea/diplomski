private Cell[][] appendArrays(Cell[][] first, Cell[][] second) {
    Cell[][] third = new Cell[first.length][first[0].length + second[0].length];

    for (int i = 0; i < first.length; i++) {
        for (int j = 0; j < first[i].length; j++) {
            third[i][j] = first[i][j];
        }
        for (int j = first[i].length; j < first[i].length + second[i].length; j++) {
            third[i][j] = second[i][j-first[i].length];
        }
    }
    return third;
}