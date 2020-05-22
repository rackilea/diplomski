TableView<List<String>> unitsTableView = new TableView<>();
idUnit = new TableColumn<List<String>, String>("Id");
idUnit.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
    @Override
    public ObservableValue<String> call(CellDataFeatures<List<String>, String>> data) {
        return new ReadOnlyStringWrapper(data.getValue().get(0)) ;
    }
});
shortNameUnit = new TableColumn<List<String>, String>("Short Name");
shortNameUnit.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
    @Override
    public ObservableValue<String> call(CellDataFeatures<List<String>, String>> data) {
        return new ReadOnlyStringWrapper(data.getValue().get(1)) ;
    }
});
nameUnit = new TableColumn<List<String>, String>("Name");
nameUnit.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
    @Override
    public ObservableValue<String> call(CellDataFeatures<List<String>, String>> data) {
        return new ReadOnlyStringWrapper(data.getValue().get(2)) ;
    }
});