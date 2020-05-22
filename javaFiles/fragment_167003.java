// ---------------------------------------Initialize the data
String[][] data = ...; // Get name/value pairs from somewhere

// ---------------------------------------Setup a TableView with two TableColumns 
    /* ... Code ... */

// ---------------------------------------Add Cell Value Factories
nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
        String[] x = p.getValue();
        if (x != null && x.length>0) {
            return new SimpleStringProperty(x[0]);
        } else {
            return new SimpleStringProperty("<no name>");
        }
    }
});

valueColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
        String[] x = p.getValue();
        if (x != null && x.length>1) {
            return new SimpleStringProperty(x[1]);
        } else {
            return new SimpleStringProperty("<no value>");
        }
    }
});

// ---------------------------------------Add Data to TableView
tableView.getItems().addAll(Arrays.asList(data));