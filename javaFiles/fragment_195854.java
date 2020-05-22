Stage stage = new Stage();
stage.setTitle("Hello World");

final BorderPane border = new BorderPane();
Scene scene = new Scene(border);

Button button = new Button("test");

HBox outerHBox = new HBox();
outerHBox.getChildren().add(button);
outerHBox.setAlignment(Pos.CENTER);

border.setCenter(outerHBox);

stage.setScene(scene);