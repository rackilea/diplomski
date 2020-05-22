void printMatrix(TableView<double[]> target, double[][] source) {

    target.getColumns().clear();
    target.getItems().clear();

    int numRows = source.length ;
    if (numRows == 0) return ;

    int numCols = source[0].length ;

    for (int i = 0 ; i < numCols ; i++) {
        TableColumn<double[], Number> column = new TableColumn<>("Column "+i);
        final int columnIndex = i ;
        column.setCellValueFactory(cellData -> {
            double[] row = cellData.getValue();
            return new SimpleDoubleProperty(row[columnIndex]);
        });
        target.getColumns().add(column);
    }

    for (int i = 0 ; i < numRows ; i++) {
        target.getItems().add(source[i]);
    }
}