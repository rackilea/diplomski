public class Main extends Application {
    @Override
    public void start(final Stage primaryStage) {
        final VBox root = new VBox(createPath());
        final Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private SVGPath createPath() {
        final SVGPath arc = new SVGPath();
        arc.setContent("M50,50 L30,50 A20,20 0 0,1 50,30 z");
        arc.setFill(Color.BLACK);
        return arc;
    }

    public static void main(final String[] args) {
        launch(args);
    }
}