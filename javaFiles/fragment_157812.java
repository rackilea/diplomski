public void start(Stage primaryStage) {
    primaryScene = buildUI(primaryStage);
    if (primaryScene == null) throw new NullPointerException();

    primaryScene.getRoot().applyCss();

    drawPane = (Pane)primaryScene.lookup("#drawPane");
    if (drawPane == null) {
        throw new NullPointerException();
}