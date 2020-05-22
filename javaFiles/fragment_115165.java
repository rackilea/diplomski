while (drs.hasNextRow()) {
    ObservableList<String> row = FXCollections.observableArrayList();
    Row sourceRow = drs.getNextRow();
    for (int i = 0; i < drs.getColumns().length; i++) {
        row.add(Objects.toString(sourceRow.getItem(i)));
    }
    data.add(row);
}