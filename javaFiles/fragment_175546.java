@Override
public void start(Stage primaryStage) {
    StackPane root = new StackPane();
    Scene scene = new Scene(root, 800, 600);
    primaryStage.setScene(scene);

    System.out.println("before sceneW " + scene.getWidth());
    System.out.println("before sceneH " +  scene.getHeight());
    System.out.println("before stageW " + primaryStage.getWidth());
    System.out.println("before stageH " + primaryStage.getHeight());

    primaryStage.show();

    System.out.println("after sceneW " + scene.getWidth());
    System.out.println("after sceneH " +  scene.getHeight());
    System.out.println("after stageW " + primaryStage.getWidth());
    System.out.println("after stageH " + primaryStage.getHeight());

    primaryStage.setMinWidth(primaryStage.getWidth());
    primaryStage.setMinHeight(primaryStage.getHeight());
}