public static int cellStatus (int column, int row) {
    for (int shipIdx = 0; shipIdx < 5; shipIdx++) {
        if (ships[shipIdx].contains(column,  row)) {
            return shipIdx;
        }
    }
    return -1;
}