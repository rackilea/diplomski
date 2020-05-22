public class GraphListener {

    ArrayList<DataEntry> entries = new ArrayList<DataEntry>();

    @FXML
    private Button updateButton;
    @FXML
    private ComboBox<String> propertiesCombo;
    @FXML
    private Button generateButton;
    @FXML
    private LineChart<Number, Number> dataChart;
    @FXML
    private TextArea statsTextArea;

    @FXML
    protected void handleUpdateButtonAction(ActionEvent event) {
        HBaseClient client = new HBaseClient();
        client.makeConnection();
        ArrayList<String> properties = client.getColumnName("demo");

        propertiesCombo.getItems().clear();
        propertiesCombo.getItems().addAll(properties);

        client.disconnect();
    }

    @FXML
    protected void handleGenerateButtonAction(ActionEvent event) {
        // Retrieving data
        String property = propertiesCombo.getSelectionModel().getSelectedItem();

        HBaseClient client = new HBaseClient();
        client.makeConnection();
        this.entries = client.scan("demo", "data", property);
        client.disconnect();

        // Filling the text area
        statsTextArea.clear();
        statsTextArea.appendText("Number of elements : " + handler.numberOfElements()+"\n");
        statsTextArea.appendText("Mean : " + handler.mean()+"\n");
        statsTextArea.appendText("Geometric mean : " + handler.geometricMean()+"\n");
        statsTextArea.appendText("Minimal value : " + handler.min()+"\n");
        statsTextArea.appendText("Maximal value : " + handler.max()+"\n");

        // Generating the graph

        dataChart.setTitle("Evolution of "+property);


        Series<Number, Number> series = new XYChart.Series<Number, Number>();
        series.setName(property);
        ArrayList<Long> timestamps = new ArrayList<Long>();
        for (DataEntry d : this.entries) {
            series.getData().add(new Data<Number, Number>(d.getTimeStamp(), d.getValue()));
            timestamps.add(d.getTimeStamp());
        }
        dataChart.getXAxis().setLabel("Timestamp");
        dataChart.getYAxis().setLabel("Values");
        dataChart.getData().add(series);

    }

}