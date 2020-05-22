Pane container = new Pane();
container.getChildren().add(imageView);

...
// event happened
container.getChildren().clear();
container.getChildren().add(mediaView);