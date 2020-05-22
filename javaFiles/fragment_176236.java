public void initialize(URL location, ResourceBundle resources) {

    data2 = FXCollections.observableArrayList();

        epc.setCellValueFactory(new PropertyValueFactory<>("epcNo"));
        modCode.setCellValueFactory(new PropertyValueFactory<>("moduleCode"));
        modClass.setCellValueFactory(new PropertyValueFactory<>("moduleClass"));
        modName.setCellValueFactory(new PropertyValueFactory<>("moduleName"));
        timestamp.setCellValueFactory(new PropertyValueFactory<>("timestamp"));