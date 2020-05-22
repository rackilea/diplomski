public class BarChartBug extends Application {

    private NumberAxis yAxis;
    private CategoryAxis xAxis;
    private BarChart<String, Number> barChart;

    private Parent createContent() {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        barChart = new BarChart<>(xAxis, yAxis);

        Button initData = new Button("init");
        initData.setOnAction(e -> {
            xAxis.setLabel("Numer indeksu");
            yAxis.setLabel("Ilo punktw");
            XYChart.Series<String, Number> series1 = new XYChart.Series<>();
            series1.getData().add(new XYChart.Data<String, Number>("Tom", 10));
            series1.getData().add(new XYChart.Data<String, Number>("Andrew", 7));
            series1.getData().add(new XYChart.Data<String, Number>("Patrick", 5));

            // hack-around:
            // xAxis.setCategories(FXCollections.observableArrayList("Tom", "Andrew", "Patrick"));
            barChart.getData().addAll(series1);

            initData.setDisable(true);

        });
        BorderPane pane = new BorderPane(barChart);
        pane.setBottom(initData);
        return pane;

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.setTitle(FXUtils.version());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger
            .getLogger(BarChartBug.class.getName());

}