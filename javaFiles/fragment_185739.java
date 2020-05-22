public class FxTest extends Application {

    public static void main(String[] args) {
        Application.launch(FxTest.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SplitPane Test");

        Group root = new Group();
        Scene scene = new Scene(root, 200, 200, Color.WHITE);

        //CREATE THE SPLITPANE
        SplitPane splitPane = new SplitPane();
        splitPane.setPrefSize(200, 200);
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.setDividerPosition(0, 0.7);

        //ADD LAYOUTS AND ASSIGN CONTAINED CONTROLS
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");

        BorderPane leftPane = new BorderPane();
        leftPane.getChildren().add(button1);

        BorderPane rightPane = new BorderPane();
        rightPane.getChildren().add(button2);

        splitPane.getItems().addAll(leftPane, rightPane);

        //ADD SPLITPANE TO ROOT
        root.getChildren().add(splitPane);

        primaryStage.setScene(scene);
        primaryStage.setVisible(true);
    }
}