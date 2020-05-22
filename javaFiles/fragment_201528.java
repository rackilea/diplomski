Dimension dim = new Dimension((int)scene.getWidth(), (int)scene.getHeight());
ChangeListener<Number> stageSizeListener = (obs, prev, next) -> {
    dim.setSize(scene.getWidth(), scene.getHeight());
    component.setSize(dim);
    swingNode.setContent(swingPanel);
};
scene.heightProperty().addListener(stageSizeListener);
scene.widthProperty().addListener(stageSizeListener);