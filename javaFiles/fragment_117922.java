VBox lotsOfLabels = new VBox();
for (int i = 1 ; i <= 100; i++) {
    Label label = new Label("Label "+i);
    lotsOfLabels.getChildren().add(label);
    label.setOnMouseClicked(e -> {
        System.out.println("Mouse click on "+label.getText());
        // etc...
    });
}