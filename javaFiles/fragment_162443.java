public class StackedBarChartSample extends Application {

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final StackedBarChart<String, Number> sbc = new StackedBarChart<String, Number>(xAxis, yAxis);

    Random rnd = new Random();

    @Override
    public void start(Stage stage) {

        stage.setTitle("Bar Chart Sample");

        sbc.setAnimated(true); //change this to false and autoscaling works!

        Button button = new Button("update");
        button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                updateChart();
            }

        });

        VBox contentPane = new VBox();
        contentPane.getChildren().addAll(sbc, button);

        Scene scene = new Scene(contentPane, 800, 600);

        stage.setScene(scene);
        stage.show();
    }


    private void updateChart(){

        int m = 1; //change this to 100 and autoscaling works!

        m = rnd.nextInt(100) + 1; // just some random value to see changes in the chart

        System.out.println( "m = " + m);

        final XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
        final XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();

        series1.setName("ABC");
        series1.getData().add(new XYChart.Data<String, Number>("one", 25*m));
        series1.getData().add(new XYChart.Data<String, Number>("two", 20*m));
        series1.getData().add(new XYChart.Data<String, Number>("three", 10*m));

        series2.setName("XYZ");
        series2.getData().add(new XYChart.Data<String, Number>("one", 25*m));
        series2.getData().add(new XYChart.Data<String, Number>("two", 20*m));
        series2.getData().add(new XYChart.Data<String, Number>("three", 10*m));

        sbc.setData( FXCollections.observableArrayList(series1, series2));
    }

    public static void main(String[] args) {
        launch(args);
    }
}