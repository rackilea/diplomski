@Override
public void start(Stage primaryStage) throws IOException {
    SceneController sceneController = new SceneController(primaryStage, new SettingsManager());
    sceneController.loadScene(LIBRARY_SELECT);
    sceneController.loadScene(LIBRARY_VIEW);
    if (sceneController.setupNeeded()) {
        sceneController.setScreen(LIBRARY_SELECT);
    } else {
        sceneController.setScreen(LIBRARY_VIEW);
    }
    primaryStage.setScene(new Scene(sceneController));
    primaryStage.show();
}

public static void main(String[] args) {
    launch(args);
}