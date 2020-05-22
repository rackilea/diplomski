DoubleBinding scaleFactor = Bindings.createDoubleBinding(() -> {
    Bounds bounds = svg.getBoundsInLocal();
    double sx = buttonWithGraphics.getWidth() / bounds.getWidth();
    double sy = buttonWithGraphics.getHeight() / bounds.getHeight();
    return 0.8 * Math.min(sx, sy); // make svg 80% of the button in the "more restrictive" direction
}, svg.boundsInLocalProperty(), buttonWithGraphics.widthProperty(), buttonWithGraphics.heightProperty());

svg.scaleXProperty().bind(scaleFactor);
svg.scaleYProperty().bind(scaleFactor);