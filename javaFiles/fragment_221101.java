Button button;
Text text;

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage primaryStage) {

    text = new Text(); 
    text.setFont(new Font(31));

    primaryStage.setTitle("My first window");
    button = new Button();
    button.setText("Click meh bro!");
    button.setTranslateX(0);
    button.setTranslateY(-100);
    button.setOnAction(this::handle);

    StackPane layout = new StackPane();
    layout.getChildren().addAll(text , button);
    Scene scene = new Scene(layout, 600, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
}

private void handle(ActionEvent event) {
    // Button was clicked, do something...
    text.setText("Hey bro , danks for clicken meh!");
}