@Override
public void start(Stage primaryStage) {

    primaryStage.setTitle("java-buddy.blogspot.com");
    VBox root = new VBox();

    TableColumn name = new TableColumn("name");
    name.setCellValueFactory(new PropertyValueFactory<Metrics, String>(
            "name"));

    TableColumn WMCCol = new TableColumn("WMC");
    WMCCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "WMC"));

    TableColumn DITCol = new TableColumn("DIT");
    DITCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "DIT"));

    TableColumn NOCCol = new TableColumn("NOC");
    NOCCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "NOC"));
    TableColumn CBOCol = new TableColumn("CBO");
    CBOCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "CBO"));
    TableColumn RFCCol = new TableColumn("RFC");
    RFCCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "RFC"));
    TableColumn LCOMCol = new TableColumn("LCOM");
    LCOMCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "LCOM"));
    TableColumn ceCol = new TableColumn("Ca");
    ceCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "ce"));
    TableColumn NPMCol = new TableColumn("NPM");
    NPMCol.setCellValueFactory(new PropertyValueFactory<Metrics, Double>(
            "NPM"));

    primaryStage.setScene(new Scene(root));
    primaryStage.show();

    List<Metrics> metric = readMetricFromCSV("C:\\Users\\pavi\\Desktop\\11.txt");
    // let's print all the metric read from CSV file
    for (Metrics m : metric) {
        System.out.println(m);

    }

    tableView.setItems(FXCollections.observableArrayList(metric));
    tableView.getColumns().addAll(name, WMCCol, DITCol, NOCCol, CBOCol,
            RFCCol, LCOMCol, ceCol, NPMCol);

    VBox vBox = new VBox();

    vBox.setSpacing(10);
    PieChart c = new PieChart();
    tableView.setOnMouseClicked(new EventHandler<Event>() {

        @Override
        public void handle(Event event) {
            c.setData(FXCollections.emptyObservableList());
            TableViewSelectionModel<Metrics> tableViewSelectionModel = tableView
                    .selectionModelProperty().get();
            Metrics m = tableViewSelectionModel.getSelectedItem();
            if (m == null) {
                return;
            }
            ObservableList<PieChart.Data> pieChartData = FXCollections
                    .observableArrayList(
                            new PieChart.Data("CBO", m.getCBO()),
                            new PieChart.Data("Ce", m.getCe()),
                            new PieChart.Data("DIT", m.getDIT()),
                            new PieChart.Data("LCOM", m.getLCOM()),
                            new PieChart.Data("NOC", m.getNOC()),
                            new PieChart.Data("NPM", m.getNPM()),
                            new PieChart.Data("WMC", m.getWMC()));
            c.setData(pieChartData);
        }
    });
    HBox boxc = new HBox();
    vBox.prefWidthProperty().bind(root.prefWidthProperty());
    boxc.setManaged(true);
    boxc.getChildren().addAll(tableView, c);
    vBox.getChildren().add(boxc);

    root.getChildren().add(vBox);

}