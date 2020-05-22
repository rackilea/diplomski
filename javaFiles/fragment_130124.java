private final double diameter = 25;
    private final LinkedList<Point2D> centers = new LinkedList<>();
    private final Canvas pane1 = new Canvas(800, 600);

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        System.out.println("Hello");
        HBox root = new HBox();

        pane1.setOnMouseClicked((MouseEvent event) ->
        {
            centers.add(new Point2D(event.getSceneX(), event.getSceneY()));
            render();
            System.out.println("Clicked");
        });
        VBox pane2 = new VBox(10);
        pane2.setPrefSize(224, 600);
        Button button1 = new Button("Clear Last Drawn");
        button1.setOnMouseClicked((MouseEvent event) ->
        {
            if (!centers.isEmpty())
            {
                centers.removeLast();
                render();
                System.out.println("Last canvas loaded");
            }
        });
        pane2.getChildren().addAll(button1);
        pane1.setStyle("-fx-background-color: #224488");
        pane2.setStyle("-fx-background-color: #224488");
        root.getChildren().addAll(pane1, pane2);
        Scene scene1 = new Scene(root, 1024, 600);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Mouse Clicker Project (Berk YATKIN)");
        primaryStage.show();

    }

    private void render()
    {
        pane1.getGraphicsContext2D().clearRect(0, 0, pane1.getWidth(), pane1.getHeight());
        centers.forEach((p) ->
        {
            pane1.getGraphicsContext2D().strokeOval(
                    p.getX() - (diameter / 2),
                    p.getY() - (diameter / 2),
                    diameter,
                    diameter);
        });
    }