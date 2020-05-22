public class Main extends Application {

    public Stage primaryStage;
    private BorderPane rootLayout;

    private final Model model ;


    @Override
    public void start(Stage primaryStage) throws Exception{

            this.model = new Model();

            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("");
            initRootLayout();
            showOverview();

    }

    public void initRootLayout(){
        try {

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class
                    .getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setHeight(900);
            primaryStage.setWidth(900);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();

            // do you really need your controllers to have access to the main app?
            // it seems like it creates excessive coupling (you can no longer
            // use this fxml-controller pair anywhere else as it has a 
            // dependency on this application class)
            controller.setMainApp(this);

            controller.initModel(model);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void showOverview(){
        try {

            // Load Overview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Overview.fxml"));
            AnchorPane overview = (AnchorPane) loader.load();

            // Set overview into the center of root layout.
            rootLayout.setCenter(overview);

            // Give the controller access to the main app.
            // WHY???

            OverviewController controller = loader.getController();
            controller.setMainApp(this);

            controller.initModel(model);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}