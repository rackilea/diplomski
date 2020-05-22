public class LineChartSample extends Application {

    private  XYChart.Series<Integer, Integer> series1, series2, series3;
    @Override
    public void start(Stage stage) {

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Integer, Integer> lineChart = new LineChart(xAxis, yAxis);

        series1 = new XYChart.Series<>();

        series1.getData().add(new XYChart.Data(1, 10));
        series1.getData().add(new XYChart.Data(10, 20));
        series1.getData().add(new XYChart.Data(20, 30));
        lineChart.getData().add(series1);

        series2 = new XYChart.Series<>();
        series2.getData().add(new XYChart.Data(1, 20));
        series2.getData().add(new XYChart.Data(10, 30));
        series2.getData().add(new XYChart.Data(20, 40));
        lineChart.getData().add(series2);

        series3 = new XYChart.Series<>();
        lineChart.getData().add(series3);
        bindDataSeieses();

        BorderPane root = new BorderPane(lineChart);
        Button btn = new Button("Add");
        btn.setOnAction(e->series1.getData().set(0, new Data<>(1, 200)));
        root.setBottom(btn);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void bindDataSeieses() {

        series1.getData().addListener((ListChangeListener<Data<Integer, Integer>>) c -> updateSumSeries());
        series2.getData().addListener((ListChangeListener<Data<Integer, Integer>>) c -> updateSumSeries());

        updateSumSeries();
    }

    private void updateSumSeries() {

        //todo enhance to support series of different length
        if(series1.getData().size() != series2.getData().size())
            throw new IllegalArgumentException("series1 and series2 must be of same length");
        series3.getData().clear();
        for (int index = 0; index < series1.getData().size(); index++){

            int xValue = series1.getData().get(index).getXValue();
            //todo verify series1.getData().get(index).getXValue() == series2.getData().get(index).getXValue()
            int yValue = series1.getData().get(index).getYValue() + series2.getData().get(index).getYValue();
            series3.getData().add(new Data<>(xValue, yValue));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}