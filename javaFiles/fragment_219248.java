public void initialize() throws Exception {
    List<String> colNames = Arrays.asList("date", "site_address", "bill_no" /*, ...*/);

    for (String colName : colNames) {
        Field f = this.getClass().getDeclaredField(colName);
        TableColumn<?,?> column = (TableColumn<?,?>) f.get(this);
        column.setCellValueFactory(new PropertyValueFactory(colName));
    }
}