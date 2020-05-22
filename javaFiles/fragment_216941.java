private SubScene createScene3D(Group group) {
    SubScene scene3d = new SubScene(group, VIEWPORT_SIZE, VIEWPORT_SIZE, true, SceneAntialiasing.BALANCED);
    scene3d.widthProperty().bind(((AnchorPane)meshGroup.getParent()).widthProperty());
    scene3d.heightProperty().bind(((AnchorPane)meshGroup.getParent()).heightProperty());

    scene3d.setFill(Color.WHITE);
    scene3d.setCamera(this.camera);
    scene3d.setPickOnBounds(true);
    return scene3d;
}