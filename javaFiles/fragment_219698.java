public class FxMain extends Application {

    private static final int VGAP = 20, HGAP = 30;

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        AnchorPane root = new AnchorPane(gridPane); //enclose grid in an AnchorPane
        gridPane.addRow(1, new Button("r1 c1"), new Button("r1 c2"));
        gridPane.addRow(2, new Button("r2 c1"), new Button("r2 c2"));
        gridPane.setVgap(VGAP); gridPane.setHgap(HGAP);

        //apply y translation: (root height/2)  minus grid pane height
        gridPane.translateYProperty().bind(root.heightProperty().divide(2).subtract(gridPane.heightProperty()));
        //apply x translation of root widt / 2
        gridPane.translateXProperty().bind(root.widthProperty().divide(2));

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}