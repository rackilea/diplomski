public static void putArrowOnRight(TitledPane pane) {
    Region title = (Region) pane.lookup(".title");
    Region arrow = (Region) title.lookup(".arrow-button");
    Text text = (Text) title.lookup(".text");

    arrow.translateXProperty().bind(Bindings.createDoubleBinding(() -> {
        double rightInset = title.getPadding().getRight();
        return title.getWidth() - arrow.getLayoutX() - arrow.getWidth() - rightInset;
    }, title.paddingProperty(), title.widthProperty(), arrow.widthProperty(), arrow.layoutXProperty()));
    arrow.setStyle("-fx-padding: 0.0em 0.0em 0.0em 0.583em;");

    DoubleBinding textGraphicBinding = Bindings.createDoubleBinding(() -> {
        switch (pane.getAlignment()) {
            case TOP_CENTER:
            case CENTER:
            case BOTTOM_CENTER:
            case BASELINE_CENTER:
                return 0.0;
            default:
                return -(arrow.getWidth());
        }
    }, arrow.widthProperty(), pane.alignmentProperty());
    text.translateXProperty().bind(textGraphicBinding);

    pane.graphicProperty().addListener((observable, oldGraphic, newGraphic) -> {
        if (oldGraphic != null) {
            oldGraphic.translateXProperty().unbind();
            oldGraphic.setTranslateX(0);
        }
        if (newGraphic != null) {
            newGraphic.translateXProperty().bind(textGraphicBinding);
        }
    });
    if (pane.getGraphic() != null) {
        pane.getGraphic().translateXProperty().bind(textGraphicBinding);
    }
}