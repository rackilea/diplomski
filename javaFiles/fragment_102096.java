public void start(Stage stage) throws Exception {

    databaseConnection db = new databaseConnection ();
    db.createConnection();

    Parent root = FXMLLoader.load(getClass().getResource("Frame.fxml"));

    Scene scene = new Scene(root);

    stage.setTitle("Albert Heijn Handterminal");
    stage.setScene(scene);
    stage.show();

}