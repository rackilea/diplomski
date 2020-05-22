@FXML
LineChart<Number, Number> lineChart;
@FXML
private NumberAxis xAxis;
@FXML
private NumberAxis yAxis;
public void chartLine() {

    XYChart.Series<Number, Number> series = new XYChart.Series<>();
    xAxis.setForceZeroInRange(false);
    lineChart.setLegendVisible(false);


    Task<Void> task = new Task<Void>() {
        @Override protected Void call() throws Exception {
            final int[] j = {0};
            for (int i=0; i<10000; i++) {
                if (isCancelled()) break;


                Platform.runLater(() -> {
                    series.getData().add(new XYChart.Data(j[0]++, Math.random()));
                    if (series.getData().size()>20) {
                        series.getData().remove(0);
                    }
                });
                Thread.sleep(2000);
            }
            return null;
        }
    };
    lineChart.getData().add(series);
    Thread th = new Thread(task);
    th.setDaemon(true);
    th.start();
}