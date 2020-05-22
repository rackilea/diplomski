public class MainApp extends Application {

    private final double MINIMUM_WINDOW_WIDTH = 500.0;
    private final double MINIMUM_WINDOW_HEIGHT = 400.0;
    private final double MAXIMUM_WINDOW_WIDTH = 800.0;
    private final double MAXIMUM_WINDOW_HEIGHT = 600.0;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new VBox();
        root.setStyle("-fx-background-color: #000;");
        //FXMLLoader.load(getClass().getResource("MainApp.fxml"))

        Scene scene = new Scene(root);

        //Set window title
        stage.setTitle("My app");

        //Set minimum window size
        stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);

        //Set maximum window size
        stage.setMaxWidth(MAXIMUM_WINDOW_WIDTH);
        stage.setMaxHeight(MAXIMUM_WINDOW_HEIGHT);

        stage.setScene(scene);
        stage.show();

        //Fade in
        DoubleProperty opacity = root.opacityProperty();
        Timeline fadeIn = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                new KeyFrame(new Duration(4000), new KeyValue(opacity, 1.0))
        );
        fadeIn.play();
    }

    public static void main(String[] args) { launch(args); }
}