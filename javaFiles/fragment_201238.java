@Override
public void start(Stage primaryStage) throws Exception {
    StackPane rootScene = FXMLLoader.load(getClass().getResource("login.fxml"));
    rootScene.getChildren().add(...);
    Scene scene = new Scene(rootScene, 900, 500);
}