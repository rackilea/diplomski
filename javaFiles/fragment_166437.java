private static final Random rand = new Random();
private static final int max = 200;

@Override
public void start(Stage primaryStage) {
    try {
        FlowPane root = new FlowPane(Orientation.VERTICAL);
        root.setPrefWrapLength(5000);
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);

        for (int i = 0; i < 200; i++) {
            Rectangle rectangle = new Rectangle(50, 50);
            rectangle.setFill(Color.rgb((int) (rand.nextDouble() * max),
                    (int) (rand.nextDouble() * max),
                    (int) (rand.nextDouble() * max)));
            root.getChildren().add(rectangle);
        }

        Scene scene = new Scene(new ScrollPane(root), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}