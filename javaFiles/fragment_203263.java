@Override
public void start(Stage stage) {
    ...
    stage.setScene(scene);
    stage.show();

    // attach keyboard to first node on scene:
    Node first = scene.getRoot().getChildrenUnmodifiable().get(0);
    if (first != null) {
        FXVK.init(first);
        FXVK.attach(first);
    }
}