@Override
public void start(Stage primaryStage) {
    Group root = new Group();

    primaryStage.setScene(new Scene(root, 500, 500));

    Rectangle robot = new Rectangle(100, 20, Color.RED);
    robot.setLayoutX(125);
    robot.setLayoutY(125);
    Line line = new Line(125, 125, 125, 25);

    robot.rotateProperty().addListener(o -> {
        Point2D start = robot.localToParent(0, 0);
        Point2D end = robot.localToParent(0, -100);
        line.setStartX(start.getX());
        line.setStartY(start.getY());
        line.setEndX(end.getX());
        line.setEndY(end.getY());
    });

    RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), robot);
    rotateTransition.setCycleCount(Animation.INDEFINITE);
    rotateTransition.setFromAngle(0);
    rotateTransition.setToAngle(360);
    rotateTransition.setInterpolator(Interpolator.LINEAR);
    rotateTransition.play();

    root.getChildren().addAll(robot, line);

    primaryStage.show();
}