// keep gridPane at original size
gridPane.setMinSize(1500, 500);
gridPane.setMaxSize(1500, 500);

StackPane root = new StackPane(gridPane);
// root.setAlignment(Pos.TOP_LEFT);

// use gridPane size to determine the factor to scale by
NumberBinding maxScale = Bindings.min(root.widthProperty().divide(1500),
                                      root.heightProperty().divide(500));
gridPane.scaleXProperty().bind(maxScale);
gridPane.scaleYProperty().bind(maxScale);

Scene scene = new Scene(root, 1500, 500);