//give driverColumn proper types
TableColumn<Trip,String> driverColumn;
//...       

driverColumn.setCellValueFactory(new Callback<CellDataFeatures<Trip, String>, ObservableValue<String>>() {
   public ObservableValue<String> call(CellDataFeatures<Trip, String> p) {
        // p.getValue() returns the Trip instance for a particular TableView row
        return new SimpleStringProperty(p.getValue().getDriver());
    }
});
driverColumn.setCellFactory(param -> new TableCell<Trip,String>{
    public void updateItem(String driver, boolean empty) {
        super.updateItem(driver, empty);

        //reset any previous values, as cells may be reused
        setText(null);
        setGraphic(null);

        if(empty) {
            //contingency if cell is empty
        } else if(driver!=null) {
            setText(driver);
        } else {
            //driver is null
            Button b = new Button("Choose Driver");
            //... hook up button actions, etc
            setGraphic(b);
        }
    }
});