private void updateTable() {
    Pane header = (Pane) myTable.lookup("TableHeaderRow");
    header.setVisible(false);
    myTable.getSelectionModel().setCellSelectionEnabled(true);
    myTable.setLayoutY(-header.getHeight());
    myTable.autosize();

    List<MyRow> list = new CopyOnWriteArrayList();
    Integer maxRows = 5, maxColumns = 5; // For example
    MyRow row;
    for (int rowId = 0; rowId <= maxRows; rowId++) {
        Boolean isEmpty = myTable.getColumns().isEmpty();
        row = new MyRow();
        Integer total = 0;
        for (int colId = 0; colId <= maxColumns; colId++) {
            if (isEmpty) {
                myTable.getColumns().add(createReactiveColumn());
            }
            TableCell cell = new MyTableCell();
            if (rowId == 0 && colId == 0) {
                // Top-left cell
            } else if (rowId == 0) {
                // Column title
                cell.setUserData(COLUMN_HEADER);
                cell.setText("CH" + Integer.toString(colId));
            } else if (colId == 0) {
                // Row title
                cell.setUserData(ROW_HEADER);
                cell.setText("RH" + Integer.toString(rowId));
            } else if (colId == maxColumns) {
                // Row 'footer'
                cell.setUserData(ROW_FOOTER);
                cell.setText(Integer.toString(total));
            } else if (rowId == maxRows) {
                // Column 'footer'
                cell.setUserData(COLUMN_FOOTER);
                cell.setText("CF" + Integer.toString(rowId));
            } else {
                // Data
                Integer r = new Random().nextInt(9); // Simulate API data
                if (!this.disabledColumns.contains(myTable.getColumns().get(colId))) {
                    total += r; // Sum of each enabled cell
                }
                cell.setUserData(DATA);
                cell.setText(Integer.toString(r));
            }
            row.add(cell);
        }
        list.add(row);
    }
    myTable.getItems().setAll(list);
}