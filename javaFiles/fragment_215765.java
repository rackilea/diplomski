public class DragMany extends Application {
    Point2D lastXY = null;
    Scene myScene;
    long lastDrag;
    ImageView dragImage; 


    void fill(Group box) {
        Color colors[] = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.MAGENTA };
        for (int i = 0; i < 100000; i++) {
            Circle c = new Circle(2);
            box.getChildren().add(c);
            c.setFill(colors[(i/17) % colors.length]);
            c.setLayoutX(i % 30 * 3);
            c.setLayoutY((i/20) % 30*3);
        }
        box.setLayoutX(40);
        box.setLayoutY(40);

    }
    void drag1(Pane pane, Group box) {
        box.setOnMousePressed(event -> {
            lastXY = new Point2D(event.getSceneX(), event.getSceneY());
            lastDrag = System.currentTimeMillis();
        });
        box.setOnMouseDragged(event -> {
            event.setDragDetect(false);
            Node on = box;
            double dx = event.getSceneX() - lastXY.getX();
            double dy = event.getSceneY() - lastXY.getY();
            on.setLayoutX(on.getLayoutX()+dx);
            on.setLayoutY(on.getLayoutY()+dy);
            lastXY = new Point2D(event.getSceneX(), event.getSceneY());
            event.consume();
        });

        box.setOnMouseReleased(d ->  lastXY = null);
    }

    void drag3(Pane pane, Group box) {
        box.setOnMousePressed(event -> {
            long now = System.currentTimeMillis();

            lastXY = new Point2D(event.getSceneX(), event.getSceneY());
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            WritableImage image = box.snapshot(params, null);
            dragImage = new ImageView(image);
            dragImage.setLayoutX(box.getLayoutX());
            dragImage.setLayoutY(box.getLayoutY());
            dragImage.setTranslateX(box.getTranslateX());
            dragImage.setTranslateY(box.getTranslateY());
            pane.getChildren().add(dragImage);
            dragImage.setOpacity(0.5);
            box.setVisible(false);
            System.out.println("Snap "+(System.currentTimeMillis()-now)+"ms");

            pane.setOnMouseDragged(e -> {
                if (dragImage == null) return;
                Node on = dragImage;
                double dx = e.getSceneX() - lastXY.getX();
                double dy = e.getSceneY() - lastXY.getY();
                on.setTranslateX(on.getTranslateX()+dx);
                on.setTranslateY(on.getTranslateY()+dy);
                lastXY = new Point2D(e.getSceneX(), e.getSceneY());
                e.consume();
            });
            pane.setOnMouseReleased(e -> {
                if (dragImage != null) {
                    box.setTranslateX(dragImage.getTranslateX());
                    box.setTranslateY(dragImage.getTranslateY());
                    pane.getChildren().remove(dragImage);
                    box.setVisible(true);
                    dragImage = null;
                }
                lastXY = null;
                e.consume();
            });

            lastDrag = System.currentTimeMillis();
            event.consume();
        });
    }

    public void start(Stage primaryStage) {
        Pane mainPane = new Pane(); 
        myScene = new Scene(mainPane, 500, 500);
        primaryStage.setScene(myScene);
        primaryStage.show();

        Group all = new Group();
        fill(all);
        mainPane.getChildren().add(all);
        drag3(mainPane, all);
    }

    public static void main(String[] args) {
        launch(args);
    }