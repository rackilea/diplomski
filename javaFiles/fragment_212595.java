GridPane overlay = new GridPane();
BorderPane pane = new BorderPane();
pane.setLeft(overlay);
StackPane background = new StackPane(pane);

// ... 
ImageView imageView = ... ;
background.getChildren().add(0, imageView);

// ...
scene.setRoot(background);