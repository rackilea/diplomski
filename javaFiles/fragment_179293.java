private TableColumn<MyRow, String> createReactiveColumn() {

    TableColumn<MyRow, String> column = new TableColumn<MyRow, String>();
    column.setCellFactory(new Callback<TableColumn<MyRow, String>, TableCell<MyRow, String>>() {
        @Override
        public TableCell<MyRow, String> call(TableColumn<MyRow, String> param) {
            return new MyTableCell();
        }
    });
    column.setSortable(FALSE);
    column.setMinWidth(40d);

    return column;
}