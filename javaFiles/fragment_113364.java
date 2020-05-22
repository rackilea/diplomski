public class MyBarChart extends Application implements Observer {
    BarChart<String, Number> bc;

    public void start(Stage stage) {
        stage.setTitle("Graphique");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Etudiants");
        xAxis.setLabel("Sections");
        //xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Nombre d'élèves");

        Scene scene = new Scene(bc, 800, 600);
        stage.setScene(scene);
        stage.show();

        initModel();
    }

    private void initModel() {
        String[] dataName = new String[]{"Informatique", "Infirmier", "Kine", "Compta"};
        double[] data = new double[]{10, 20, 30, 40};
        ChartModel cm = new ChartModel();
        cm.setChartData(dataName, data);
        cm.addObserver(this);
        new Thread(() -> {
            cm.updateCharData("Informatique", 50);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {//trt
            }
            cm.updateCharData("Informatique", 10);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {//trt
            }
        }).start();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ChartModel) {
            ChartModel cm = (ChartModel) o;
            Map<String, Double> data = cm.getData();

            // make sure to read the data from the thread that does the updates
            // or make sure the data is synchronized

            final XYChart.Series<String, Number>[] series = new XYChart.Series[data.size()];

            int index = 0;
            for (Map.Entry<String, Double> entry : cm.getData().entrySet()) {
                XYChart.Series<String, Number> series1 = new XYChart.Series<>();
                series1.setName(entry.getKey());
                series1.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
                series[index] = series1;
                index++;
            }

            // updates to the gui on the javafx application thread
            Platform.runLater(() -> bc.getData().setAll(series));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}