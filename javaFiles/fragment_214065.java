@Override
public void start(Stage primaryStage) {
    Pane root = new Pane();

    Polygon poly = new Polygon( 0, 0, 30, 15, 0, 30); 
    poly.setFill(Color.YELLOW);
    poly.setStroke(Color.RED);
    root.getChildren().add(poly);

    Rectangle rectangle = new Rectangle(200, 100, 100, 400);
    rectangle.setFill(Color.TRANSPARENT);
    rectangle.setStroke(Color.BLUE);

    Circle circle = new Circle(50);
    circle.setFill(Color.TRANSPARENT);
    circle.setStroke(Color.RED);
    circle.setStrokeWidth(3);

    root.getChildren().add(rectangle);
    root.getChildren().add(circle);

    PathInterpolator in1=new PathInterpolator(rectangle, circle);
    PathInterpolator in2=new PathInterpolator(circle, poly);

    AnimationTimer timer1 = new AnimationTimer() {

        @Override
        public void handle(long now) {
            double millis=(now/1_000_000)%10000;
            in1.interpolate(millis/10000);
        }
    };

    AnimationTimer timer2 = new AnimationTimer() {

        @Override
        public void handle(long now) {
            double millis=(now/1_000_000)%2000;
            // Interpolate over the translated circle
            in2.interpolate(millis/2000,
                            circle.getTranslateX(),
                            circle.getTranslateY());
        }
    };
    timer2.start();
    timer1.start();

    Scene scene = new Scene(root, 800, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
}