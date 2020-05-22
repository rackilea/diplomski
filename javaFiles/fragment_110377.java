public class TextAnimationDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getContent(), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private BorderPane getContent() {
        Text text = new Text("Title");

        Button fadeIn = new Button("Fade In");
        fadeIn.setOnAction(e -> fadeIn(text));

        Button fadeOut = new Button("Fade Out");
        fadeOut.setOnAction(e -> fadeOut(text));

        Button slideDown = new Button("Slide-Down");
        slideDown.setOnAction(event -> slideDown(text));

        BorderPane root = new BorderPane();
        root.setCenter(text);
        root.setRight(fadeOut);
        root.setLeft(fadeIn);
        root.setBottom(slideDown);
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}