TableColumn col = new TableColumn("column header name you want");
col.setCellFactory(factory -> new CheckBoxTableCell());
col.setCellValueFactory(v -> {
        BooleanProperty property = new SimpleBooleanProperty();
        property.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                tableView.getItems().remove(((TableColumn.CellDataFeatures)v).getValue());
            }
        });
    return property;
});
tableView.getColumns().add(col);