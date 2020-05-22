public class MyApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        ParseTask task = new ParseTask(...);

        DxProgressIndicator indicator = new DxProgressIndicator();
        indicator.setTotalLines(task.getTotalLines());
        indicator.progressProperty().bind(task.progressProperty());

        Scene scene = new Scene(indicator.getRoot());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dexter Parser");

        primaryStage.show();

        new Thread(task).start();
    }
}