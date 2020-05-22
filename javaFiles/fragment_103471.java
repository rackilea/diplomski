public class JavaFxApp extends Application implements Observe{

    private Label label;

    @Override public void start(Stage stage) {
        label = new Label("waiting");
        BorderPane pane = new BorderPane(label);
        Scene scene = new Scene(pane, 100, 100);
        stage.setScene(scene);
        stage.show();
    }

    @Override public void update(int i) {
        Platform.runLater(()-> label.setText(String.valueOf(i)));
    }
}