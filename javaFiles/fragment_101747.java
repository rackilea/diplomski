public void initialize() {
    String treeItemCss = ... ;
    main.sceneProperty().addListener((obs, oldScene, newScene) -> {
        if (newScene != null) {
            newScene.getStylesheets().add(treeItemCss);
        }
    });
}