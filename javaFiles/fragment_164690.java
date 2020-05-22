Pane viewPort = new Pane();
viewPort.getChildren().add(yourSwingNode);

// Top 200px and bottom 200px of yourSwingNode will be trimed.
yourSwingNode.setLayoutY(-200.0);
yourSwingNode.layoutBoundsProperty().addListener((o, ov, nv) -> {
    viewPort.setMaxHeight(nv.getHeight() - 400.0);
});

// Set a clip for the layout bounds of Pane if you need
Rectangle clip = new Rectangle();
viewPort.layoutBoundsProperty().addListener((o, ov, nv) -> {
    clip.setWidth(nv.getWidth());
    clip.setHeight(nv.getHeight());
});
viewPort.setClip(clip);