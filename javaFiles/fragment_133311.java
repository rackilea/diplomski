public class OpenPilot extends Application {

    Movements movements;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        // use non-static load method here
        Parent root = fxmlLoader.load(getClass().getResource("FXMLDocument.fxml").openStream());

        // get movements from via controller
        FXMLDocumentController controller = fxmlLoader.<FXMLDocumentController>getController();
        movements = controller.getMovements();

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent Key) {
               movements.GetKeys(Key);
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}