@Override
public void initialize(URL url, ResourceBundle rb) {

    search.bind(searchTextField.textProperty());
    nomMarqueurColumn.setCellValueFactory(cellData -> cellData.getValue().getN_Marqueur());
    latitudeColumn.setCellValueFactory(cellData -> cellData.getValue().getCoordonnees().getLatitude().asObject());
    longitudeColumn.setCellValueFactory(cellData -> cellData.getValue().getCoordonnees().getLongitude().asObject());
    timeColumn.setCellValueFactory(cellData -> cellData.getValue().getTimeNextStringPropertyTime());
    //Remplissages des textFields
    startTimeTextField.setText(TimeUtil.formatTime(MapMarker.getTimeStart()));
    startDateTextField.setText(TimeUtil.formatDate(MapMarker.getTimeStart()));
}