public class UpdaterApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // whatever you need to launch the updater app here...

    }

    // invoke from the FX Application Thread to "start" main app:
    private void showMainApp(Stage stage) {
        MainApp app = new MainApp();
        app.initializeAndShowStage(stage);
    }

    private void showMainApp() {
        showMainApp(new Stage());
    }

    public static void main(String[] args) {
        launch(args);
    }
}