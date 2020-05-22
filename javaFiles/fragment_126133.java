public class JavaFX11 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new StackPane(new Label("JavaFX 11")), 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}