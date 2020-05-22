@Override
public void start(Stage primaryStage) throws IOException {

    FXMLLoader loader = new FXMLLoader();
    AnchorPane page = (AnchorPane) loader.load(getClass().getResourceAsStream("MainScene.fxml"));
    Scene scene = new Scene(page);
    MainSceneController controller = loader.getController();
    controller.initializeAccelerators();

    primaryStage.setScene(scene);
    primaryStage.show();
}