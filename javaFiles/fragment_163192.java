Button button = new Button("Hello");
Text text = new Text("hello");

HBox hbox = new HBox();
hbox.getChildren().addAll(button, text); // button will be left of text

Image image = new Image("space.jpg",x,y, false, false);
ImageView iv1 = new ImageView();

StackPane stackPane = new StackPane();
stackPane.getChildren().addAll(iv1, hbox); // hbox with button and text on top of image view

HBox root = new HBox();
root.getChildren().add(stackPane);

// etc