public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            StackPane root = new StackPane();
            Text text2 = new Text("I will be aligned TOPLEFT");
            Text text = new Text(" Level 2 \n\n" + "Press ENTER to start a new game");
            text.setTextAlignment(TextAlignment.CENTER);
            root.getChildren().addAll(text2, text);
            StackPane.setAlignment(text2, Pos.TOP_LEFT);
            StackPane.setAlignment(text, Pos.CENTER);


            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}