@Override
public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));        
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    root.requestFocus(); // add this, root is the VBox in your case
}