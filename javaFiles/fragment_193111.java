public class Example extends Application {

    Font fontLarge = Font.font("Droid Sans", FontWeight.BOLD, 15);

    @Override
    public void start(Stage stage) {

        HBox root = new HBox();
        Scene scene = new Scene(root, Color.YELLOW);

        root.getChildren().add(getCanvasOfRationalNumber("5", "7"));
        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
    }

    public Canvas getCanvasOfRationalNumber(String num, String denom) {
        final Canvas rnCanvas = new Canvas(300, 55);
        GraphicsContext gc = rnCanvas.getGraphicsContext2D();
        gc.setFont(fontLarge);

        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, 300, 55);

        gc.setFill(Color.BLUE);

        gc.fillText(num, 0, 15);
        gc.fillText("___", 0, 20);
        gc.fillText(denom, 0, 40);

        rnCanvas.setWidth(15);
        return rnCanvas;
    }

    public static void main(String[] args) {
        launch(args);
    }

}