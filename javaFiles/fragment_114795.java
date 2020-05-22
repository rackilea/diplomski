final FXCanvas canvas = new FXCanvas(parent, SWT.NONE);
    button = new Button();
    button.setText("FxButton (1)");
    button.setStyle("-fx-background-color: #186dee; -fx-text-fill: white;");

    final HBox box = new HBox();
    box.getChildren().add(button);

    final Scene scene = new Scene(box);
    canvas.setScene(scene);