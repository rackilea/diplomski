public void updateGrid(int cols, int rows) {
    List<RowConstraints> rowList = gameGrid.getRowConstraints();
    rowList.clear();
    if (rows > 0) {
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100d / rows);
        for (int i = 0; i < rows; i++) {
            rowList.add(rowConstraints);
        }
    }

    List<ColumnConstraints> columnList = gameGrid.getColumnConstraints();
    columnList.clear();
    if (cols > 0) {
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(100d / cols);
        for (int i = 0; i < cols; i++) {
            columnList.add(columnConstraints);
        }
    }
}