public void start(Stage primaryStage) {
    Path path = new Path(new MoveTo(), new CubicCurveTo(100, 100, 150, 50, 200, 100));
    Rectangle rect = new Rectangle(10, 10);
    Rectangle back = new Rectangle(100, 50, Color.RED);
    back.setVisible(false);

    // original transition
    PathTransition transition = new PathTransition(Duration.seconds(5), path, rect);

    // transition for triggering halftime event
    PauseTransition pause = new PauseTransition(transition.getCycleDuration().multiply(0.5));
    pause.setOnFinished(evt -> back.setVisible(true));

    // combine & play transitions
    ParallelTransition animation = new ParallelTransition(rect, transition, pause);
    animation.play();

    Scene scene = new Scene(new Pane(back, rect), 300, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
}