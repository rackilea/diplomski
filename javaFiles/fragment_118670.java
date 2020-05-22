public void setRowData(Trip rowData) {
    this.rowData = rowData;
    populateTravelPlan();
}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
    addTraveler.setDisable(true);
    removeTraveler.setDisable(true);
    // don't do this here:
    // populateTravelPlan();
}