@Override
public void start(Stage primaryStage) throws Exception{

    FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(getClass().getResource("sample.fxml"));

    Parent root = fxmlLoader.load();
    controller = fxmlLoader.getController();

    primaryStage.setTitle("uPick Smart Service");
    primaryStage.setScene(new Scene(root, 1600, 600));

    primaryStage.show();



}