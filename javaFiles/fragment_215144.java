public class TransparentStage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.TRANSPARENT);
        Circle c = new Circle(30);
        c.setFill(Color.RED);
        VBox box = new VBox();
        box.getChildren().add(c);
        final Scene scene = new Scene(box,300, 250);
        scene.setFill(null);
        stage.setScene(scene);
        stage.setX(20);
        stage.setY(Screen.getPrimary().getBounds().getHeight() - 100);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}