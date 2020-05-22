public TableView<List<String>> readTabDelimitedFileIntoTable(Path file) throws IOException {
    TableView<List<String>> table = new TableView<>();
    Files.lines(file).map(line -> line.split("\t")).forEach(values -> {
        // Add extra columns if necessary:
        for (int i = table.getColumns().size(); i < values.length; i++) {
            TableColumn<List<String>, String> col = new TableColumn<>("Column "+(i+1));
            col.setMinWidth(80);
            final int colIndex = i ;
            col.setCellValueFactory(data -> {
                List<String> rowValues = data.getValue();
                String cellValue ;
                if (colIndex < rowValues.size()) {
                    cellValue = rowValues.get(colIndex);
                } else {
                     cellValue = "" ;
                }
                return new ReadOnlyStringWrapper(cellValue);
            });
            table.getColumns().add(col);
        }

        // add row:
        table.getItems().add(Arrays.asList(values));
    });
    return table ;
}