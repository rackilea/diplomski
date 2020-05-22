@FXML
private void handleButtonAction(ActionEvent event) {
    JsonConverter jsonConvert = new JsonConverter("jsonCase", CaseTable.class);
    RestSource test = RestSourceBuilder.create()
                      .converter(jsonConvert)
                      .host("http://devel.com.au")
                      .path("cgi-bin").path("ssinternalweb-jcgi.sh")
                      .queryParam("Program", "appfx/CaseTest.p")
                      .queryParam("ProcName", "FXRequest")
                      .queryParam("TestParam", "aValue").build();
    lvCases.getItems().removeAll(lvCases.getItems());
    ListDataProvider<CaseTable> ldp = ListDataProviderBuilder.create()
            .dataReader(test)
            .resultList(lvCases.getItems())
            .build();
    Worker<ObservableList<CaseTable>>retrieve = ldp.retrieve();                                                                                         
}

@Override
public void initialize(URL url, ResourceBundle rb) {
    lvCases.setCellFactory(l -> new CaseTableCell());
    lvCases.getItems().add(new CaseTable(999, "Loading..."));
}