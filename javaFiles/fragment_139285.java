public class MainApp extends Application {

    private Parent uiContent ;

    public static final double DEFAULT_WIDTH = 800 ;
    public static final double DEFAULT_HEIGHT = 600 ;

    public Parent getContent() {
        if (uiContent == null) {
            uiContent = initializeUI();
        }
        return uiContent ;
    }

    public Scene createScene() {
        return new Scene(getContent(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void initializeAndShowStage(Stage stage) {
        stage.setScene(createScene());
        stage.show();
    }

    private Parent initializeUI() {
        // probably wise to check we are on the FX Application thread here...
        Pane root = ... ;
        // build ui....
        return root ;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeAndShowStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}