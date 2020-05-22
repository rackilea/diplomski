public class Dumbell extends Group {

    private boolean dragging ;

    public Dumbell() {

        Line joiner = new Line();
        joiner.setId("joiner");
        joiner.setStroke(Paint.valueOf("#00c9e0"));
        joiner.setStrokeWidth(1);

        Circle rball = createBall(30, 50);
        Circle lball = createBall(20, 40);

        joiner.startXProperty().bind(rball.centerXProperty());
        joiner.startYProperty().bind(rball.centerYProperty());
        joiner.endXProperty().bind(lball.centerXProperty());
        joiner.endYProperty().bind(lball.centerYProperty());

        getChildren().addAll(joiner, lball, rball);
    }

    private Circle createBall(double x, double y) {
        Circle ball = new Circle(x, y, 2);
        ball.setFill(Paint.valueOf("#00c9e0"));
        ball.setOnMousePressed(e -> dragging = true );
        ball.setOnMouseDragged(e -> {
            if (dragging) {
                ball.setCenterX(e.getX());
                ball.setCenterY(e.getY());
            }
        });
        ball.setOnMouseReleased(e -> dragging = false);
        return ball ;
    }
}