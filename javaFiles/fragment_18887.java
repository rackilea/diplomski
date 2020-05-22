public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Model m = new Model();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("views/VueGlobale.fxml"));
        loader.setControllerFactory(ic -> {
            if (ic == ClavierController.class) {
                return new ClavierController(m);
            } else if (ic == TopController.class) {
                return new TopController(m);
            } else if (ic == BottomController.class) {
                return new BottomController(m) ;
            }
            throw new IllegalArgumentException("Unexpected controller type: "+ic.getName());
        });

        Parent root = loader.load();
        primaryStage.setTitle("Test");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}