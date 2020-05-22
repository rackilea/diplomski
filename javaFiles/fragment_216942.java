private static final double MODEL_SCALE_FACTOR = 6;

private void initCamera() {
    this.camera = new PerspectiveCamera(true);
    this.camera.setNearClip(0.1);
    this.camera.setFarClip(10000.0);
    this.camera.setTranslateZ(-2000);
}
private Group buildScene() {
    Group group = new Group();

    meshView.setScaleX(MODEL_SCALE_FACTOR);
    meshView.setScaleY(MODEL_SCALE_FACTOR);
    meshView.setScaleZ(MODEL_SCALE_FACTOR);

    PointLight pointLight = new PointLight(Color.WHITE);
    pointLight.setTranslateZ(-2*VIEWPORT_SIZE );
    pointLight.setTranslateY(-2*VIEWPORT_SIZE );

    group.getChildren().addAll(meshView, pointLight);
    return group;
}