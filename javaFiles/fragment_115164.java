TableView<ObservableList<String>> table = ...
int index = 0;
for (Column col : drs.getColumns()) {
    final int columnIndex = index++;
    TableColumn<ObservableList<String>, String> tblCol = new TableColumn(col.getName());
    tblCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList<String>, String>, ObservableValue<String>>(){
        public ObservableValue<String> call(CellDataFeatures<ObservableList, String> p) {
            return Bindings.stringValueAt(p.getValue(), columnIndex);
        }
    });
    table.getColumns().add(tblCol);
}