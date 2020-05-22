public class JavaFxApp extends Application {

    private static Label label = new Label("waiting");

    @Override public void start(Stage stage) {  
        BorderPane pane = new BorderPane(label);
        Scene scene = new Scene(pane, 100, 100);
        stage.setScene(scene);
        stage.show();
    }

    static Observe getObserver() {
        return JavaFxApp::update;
    }

    private static void update(int i) {
        Platform.runLater(()-> label.setText(String.valueOf(i)));
    }
}