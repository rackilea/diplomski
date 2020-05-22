public class CPCS305_JAVAFX_FXML extends Application {
    @FXML // because there is a fx:id="main_label"  in the FXML
    private Label main_label;  // Java naming convention would be mainLabel

    @FXML // because there is a fx:id="login_button"  in the FXML
    private Button login_button; // Java naming convention would be loginButton

    @Override
    public void start(Stage stage) throws Exception {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
       loader.setControllerFactory(controllerClass -> this); // 'this' object will be the controller.
       Parent root = loader.load();
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }

   @FXML // because there is a onAction="#handleButtonAction" in the FXML
   private void handleButtonAction() { // parameter is optional
      main_label.setText("Hello World");
   }
}