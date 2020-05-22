public class StockApp extends Application {

    @Override
    public void start(Stage stage) {
        FormBuilder formBuilder = new FormBuilder();
        Scene scene = new Scene(formBuilder.getView(), 1024, 800, Color.WHITE);
        stage.setTitle("Stock Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}