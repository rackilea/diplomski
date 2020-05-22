List<List<GameObject>> board = new ArrayList<>();
for (int r = 0; r < rowCount; r++) {
    List<GameObject> row = new ArrayList<>();
    for (int c = 0; c < columnCount; c++) {
        GameObject cell = new GameObject();
        row.add(cell);
    }
    board.add(row);
}