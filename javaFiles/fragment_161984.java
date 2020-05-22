public class Test extends Application {

    ScrollPane scrollPane;
    int pos = 0;
    final int minPos = 0;
    final int maxPos = 100;

    @Override
    public void start(Stage primaryStage) {

        Label label = new Label("TEXT!!!!!!!TEXT!!!!!!!TEXT!!!!!!!TEXT!!!!!!!TEXT!!!!!!!TEXT");
        label.setPrefSize(500, 100);
        label.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {

                if (event.getDeltaY() > 0)
                    scrollPane.setHvalue(pos == minPos ? minPos : pos--);
                else
                    scrollPane.setHvalue(pos == maxPos ? maxPos : pos++);

            }
        });

        scrollPane = new ScrollPane();
        scrollPane.setHmin(minPos);
        scrollPane.setHmax(maxPos);
        scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setPannable(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setContent(label);

        BorderPane root = new BorderPane();
        root.setPrefSize(200, 100);
        root.setCenter(scrollPane);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}