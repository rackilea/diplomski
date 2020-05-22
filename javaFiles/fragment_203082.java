@Override
    public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("jobController.fxml"));        
    Scene scene = new Scene(root);        
    stage.setScene(scene);
    stage.show();
}