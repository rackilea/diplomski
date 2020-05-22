static void skipCells(Cell cell,int ...cellPosition) {
    for (int i: cellPosition) {
        if (cell.getColumnIndex() == i) {
            break;
        }
    }
}