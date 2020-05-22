public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        LineChart<Number, Number> chart = new LineChart<>(new NumberAxis(), new NumberAxis());
        ScrollPane scrollPane = new ScrollPane(chart);
        primaryStage.setScene(new Scene(scrollPane, 300, 300));
        primaryStage.show();
        scrollPane.setVvalue(0.5);
        scrollPane.setHvalue(0.5);
    }

    public static void main(String[] args) {
        launch(args);
    }
}