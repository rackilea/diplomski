VBox panel = new VBox();

// parent to be resized
Pane pane = new Pane(canvas);

// grow/shrink pane when VBox height is increased/decreased    
VBox.setVgrow(pane, Priority.ALWAYS);

// bind canvas size to parent size
canvas.widthProperty().bind(pane.widthProperty());
canvas.heightProperty().bind(pane.heightProperty());

panel.getChildren().addAll(topPane, pane);