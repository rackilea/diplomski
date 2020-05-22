ToolBar tb = new ToolBar();
    TextField tf = new TextField();
    HBox hbox = new HBox(8);
    hbox.prefWidthProperty().bind(tb.widthProperty().subtract(20));
    HBox.setHgrow(tf, Priority.ALWAYS);
    hbox.getChildren().add(new Button("<-"));
    hbox.getChildren().add(new Button("->"));
    hbox.getChildren().add(tf);
    tb.getItems().add(hbox);