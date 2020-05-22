public class Tdesst extends Application {

    private void init(Stage primaryStage) {
        VBox root = new VBox();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        final ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Sun", 20),
                new PieChart.Data("IBM", 12),
                new PieChart.Data("HP", 25),
                new PieChart.Data("Dell", 22),
                new PieChart.Data("Apple", 30));
        final PieChart chart = new PieChart(pieChartData);

        final CheckBox chkbox = new CheckBox("add/remove data");

        final Timeline animation = new Timeline(
                new KeyFrame(Duration.seconds(.5),
                new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent actionEvent) {
                        chkbox.setDisable(false);
                    }
                }));
        animation.setCycleCount(1);

        chkbox.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldVal, Boolean newVal) {
                chkbox.setDisable(true);
                if (newVal) {
                    pieChartData.add(new PieChart.Data("newValue", 34));
                } else {
                    pieChartData.remove(pieChartData.size() - 1);
                }
                animation.play();
            }
        });

        root.getChildren().add(chart);
        root.getChildren().add(chkbox);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
        primaryStage.setTitle(VersionInfo.getRuntimeVersion());
    }

    public static void main(String[] args) {
        launch(args);
    }
}