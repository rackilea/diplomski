Button button = new Button("I am a button");
button.setOnAction(event -> minimizeStageOfNode((Node) event.getSource()));

ImageView imageView = new ImageView();
imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
     minimizeStageOfNode((Node) event.getSource()));