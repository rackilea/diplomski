private Group buildScene() {
    meshView.setTranslateX(VIEWPORT_SIZE / 2);
    meshView.setTranslateY(VIEWPORT_SIZE / 2 * 9.0 / 16);
    meshView.setTranslateZ(-VIEWPORT_SIZE);
    meshView.setScaleX(MODEL_SCALE_FACTOR);
    meshView.setScaleY(MODEL_SCALE_FACTOR);
    meshView.setScaleZ(MODEL_SCALE_FACTOR);
    meshView.setCullFace(CullFace.NONE);
    Group group = new Group(meshView);

    AmbientLight ambient = new AmbientLight(); // default color white
    ambient.setLightOn(true); // switch it off and everything is black

    group.getChildren().add(ambient);
    return group;
  }