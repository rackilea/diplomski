public Cell getCellAt(int row, int column) {
    Cell c = null;
    for (Cell cell : cells) {
        if (cell.is(row, column)) {
            c = cell;
        }
    }
    return c;
}