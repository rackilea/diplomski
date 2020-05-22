public class MyApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(...);
        Parent root = loader.load();
        MyController controller = loader.getController();
        controller.setHostServices(getHostServices());
        //... setup and show scene and stage...
    }
}