void printMatrix(TableView<double[]> target, double[][] source) {

    target.getColumns().clear();
    target.getItems().clear();

    int numRows = source.length ;

    for (int rowIndex = 0 ; rowIndex < numRows ; rowIndex++) {
        for (int i = target.getColumns().size(); i < source[rowIndex].length ; i++) {
            TableColumn<double[], Number> column = new TableColumn<>("Column "+i);
            final int columnIndex = i ;
            column.setCellValueFactory(cellData -> {
                double[] row = cellData.getValue();
                double value ;
                if (row.length <= columnIndex) {
                    value = 0 ;
                } else {
                    value = row[columnIndex] ;
                }
                return new SimpleDoubleProperty(value);
            });
            target.getColumns().add(column);
        }
        target.getItems().add(source[rowIndex]);
    }
}