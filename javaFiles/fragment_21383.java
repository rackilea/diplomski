private Label createLabel(int index) {
    Label label = new Label();
    label.setOnMouseEntered(e -> {
        label.setStyle("-fx-background-color: black;");
        // other things you need to do when the mouse hovers....
    });
    // other label configuration...
    return label ;
}