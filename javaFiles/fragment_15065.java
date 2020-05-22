public static Node createCondensingLabel(String regularText,
                                         String condensedText) {

    Label regularLabel = new Label(regularText);
    Label condensedLabel = new Label(condensedText);

    StackPane pane = new StackPane(regularLabel, condensedLabel);

    BooleanBinding fullyVisible = Bindings.createBooleanBinding(() ->
        regularLabel.getWidth() >=
            regularLabel.prefWidth(regularLabel.getHeight()),
        regularLabel.widthProperty());

    regularLabel.visibleProperty().bind(fullyVisible);
    condensedLabel.visibleProperty().bind(fullyVisible.not());

    return pane;
}