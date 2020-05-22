Pane secondSlideOverlay = new Pane();

secondSlideOverlay.prefWidthProperty().bind(secondSlideCore.widthProperty());
secondSlideOverlay.prefHeightProperty().bind(secondSlideCore.heightProperty());

DoubleExpression w2 = secondSlideCore.widthProperty().multiply(.5);

Line mainOverlay = new Line();
mainOverlay.startXProperty().bind(w2);
mainOverlay.endXProperty().bind(w2);
mainOverlay.endYProperty().bind(secondSlideCore.heightProperty());