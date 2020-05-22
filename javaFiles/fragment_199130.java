public class MyMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 200, 300));
        primaryStage.setMinWidth(220);
        primaryStage.setMinHeight(340);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}