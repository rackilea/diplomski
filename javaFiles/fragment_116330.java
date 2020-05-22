public class TestSceneBuilder extends Application {
    final int H = 300, W = 300;
    BorderPane root;
    Canvas canvas;
    ColorPicker cp;
    Button btn;

    @Override
    public void start(Stage primaryStage) {
        root = this.setScene();
        Scene scene = new Scene(root, H, W);

        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    BorderPane setScene(){
        BorderPane border = new BorderPane();

        cp = new ColorPicker(Color.AQUA);
        canvas = new Canvas(H, W);
        btn = new Button("Draw");

        btn.setOnAction((event) -> {
            canvas.getGraphicsContext2D().setFill(cp.getValue());
            canvas.getGraphicsContext2D().fillOval(20, 20, 20, 20);
        });


        HBox hb = new HBox();
        hb.getChildren().addAll(btn, cp);
        border.setTop(hb);
        BorderPane.setAlignment(hb, Pos.CENTER);

        border.setCenter(canvas);
        return border;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}