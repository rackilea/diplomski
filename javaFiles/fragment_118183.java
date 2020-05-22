public class Main extends Application {
    public Controller controller1;
    public Controller controller2;
    private Stage primaryStage;

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        controller1 = load("Screen 1.fxml");
        controller2 = load("Screen 2.fxml");

        primaryStage.setTitle("Hello World");
        controller1.goToScreen1();
        primaryStage.show();
    }

    public Controller load(final String name) throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
        loader.load();
        final Controller controller = loader.getController();
        controller.configure(this, new Scene(loader.getRoot()));
        return controller;
    }

    public void show(final Scene scene) {
        primaryStage.setScene(scene);
    }
}