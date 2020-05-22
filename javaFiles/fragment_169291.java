public class FXScreens extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 200, 250);

        int index = 1;
        for (Screen screen : Screen.getScreens()) {
            Rectangle2D bounds = screen.getVisualBounds();

            Button btn = new Button("Move me to Screen " + index++);
            btn.setOnAction((e) -> {
                stage.setX(bounds.getMinX() + 100);
                stage.setY(bounds.getMinY() + 100);
            });
            root.getChildren().add(btn);
        }

        stage.setTitle("Screen Jumper");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}