@Override
public void start(Stage primaryStage) throws Exception {

    splashScene.setFill(Color.TRANSPARENT);
    splashScene.getStylesheets().add("splashStyle.css");

    primaryStage.setScene(splashScene);
    primaryStage.initStyle(StageStyle.TRANSPARENT);
    primaryStage.show();

}