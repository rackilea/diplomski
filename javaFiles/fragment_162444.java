public class StackedBarChartSample extends Application {

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final StackedBarChart<String, Number> sbc = new StackedBarChart<String, Number>(xAxis, yAxis);

    Random rnd = new Random();

    final XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
    final XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();

    @Override
    public void start(Stage stage) {

        stage.setTitle("Bar Chart Sample");

        sbc.setAnimated(true); //change this to false and autoscaling works!

        Button createButton = new Button("Create");
        createButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                createChartData();
            }

        });

        Button modifyButton = new Button("Modify");
        modifyButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                modifyChartData();
            }

        });

        VBox contentPane = new VBox();
        contentPane.getChildren().addAll(sbc, createButton, modifyButton);

        Scene scene = new Scene(contentPane, 800, 600);

        stage.setScene(scene);
        stage.show();
    }


    private void createChartData(){

        int m = 1; //change this to 100 and autoscaling works!

        m = rnd.nextInt(100) + 1; // just some random value to see changes in the chart

        System.out.println( "m = " + m);

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

    private void modifyChartData() {

        int m = 1; //change this to 100 and autoscaling works!

        m = rnd.nextInt(100) + 1; // just some random value to see changes in the chart

        System.out.println( "m = " + m);

        for( XYChart.Data<String,Number> data: series1.getData()) {
            data.setYValue(rnd.nextInt(30) * m);
        }

        for( XYChart.Data<String,Number> data: series2.getData()) {
            data.setYValue(rnd.nextInt(30) * m);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}