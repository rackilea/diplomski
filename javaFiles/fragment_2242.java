private static Label createLabel(String text, double layoutY, double majorTickDistance, int index) {
    Label label = new Label(text);

    // label width should be exactly the distance between ticks
    label.setMaxWidth(Region.USE_PREF_SIZE);
    label.setMinWidth(Region.USE_PREF_SIZE);
    label.setPrefWidth(majorTickDistance);

    // center text
    label.setAlignment(Pos.BASELINE_CENTER);
    label.setLayoutY(layoutY);

    // align center of the label with major tick
    label.setLayoutX((index + 0.5) * majorTickDistance);
    return label;
}

/**
 * @param majorTickDistance the width between major ticks
 * @param minorTicks the number of minor ticks between major ticks
 * @param majorTickHeight the height of major tick markers
 * @param minorTickHeight the height of minor tick markers
 * @param firstText the first text for the first major tick
 * @param text the text for other ticks
 */
private static Pane createAxis(double majorTickDistance, int minorTicks,
        double majorTickHeight, double minorTickHeight, String firstText, String... text) {
    final double labelY = majorTickHeight + 3;
    final double minorTickDistance = majorTickDistance / minorTicks;

    // initialize path with first major tick and horizontal line
    Path path = new Path(
            new MoveTo(0, 0), new HLineTo(majorTickDistance * text.length),
            new MoveTo(0, 0), new VLineTo(majorTickHeight)
    );

    // add path and first label
    Pane pane = new Pane(path, createLabel(firstText, labelY, majorTickDistance, -1));

    for (int i = 0; i < text.length; i++) {
        double offset = i * majorTickDistance;

        // add minor ticks
        for (int j = 1; j < minorTicks; j++) {
            double x = offset + j * minorTickDistance;
            path.getElements().addAll(new MoveTo(x, 0), new VLineTo(minorTickHeight));
        }
        offset += majorTickDistance;

        // add major tick at the end of the current interval
        path.getElements().addAll(new MoveTo(offset, 0), new VLineTo(majorTickHeight));

        // add label below major tick
        pane.getChildren().add(createLabel(text[i], labelY, majorTickDistance, i));
    }

    pane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

    return pane;
}

@Override
public void start(Stage primaryStage) throws Exception {

    Scene scene = new Scene(new StackPane(createAxis(30, 5, 10, 5, "1", "2", "3", "4", "5", "6")), 400, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}