public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Sample.fxml"));
        Scene scene = new Scene(loader.load());

        primaryStage.setScene(scene);

        Controller controller = loader.getController();
        controller.setStartingPosition(primaryStage);

        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}