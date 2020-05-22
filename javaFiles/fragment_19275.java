HBox top = new HBox(
    createLabel("White", "white-check"),
    createLabel("Light Gray", "lightgray-check")
);
. . . 
public Label createLabel(String text, String styleClass) {
    Label label = new Label(text);
    label.getStyleClass().add(styleClass);
    label.setMinWidth(160);
    label.setMinHeight(60);

    return label
}