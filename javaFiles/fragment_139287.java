public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // .... build UI etc
    }

    public static void main(String[] args) throws Exception {
        if (Platform.isFXApplicationThread()) {
            Stage someStage = new Stage();
            MainApp app = new MainApp();
            app.start(stage);
        } else {
            launch(args);
        }
    }
}