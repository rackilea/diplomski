public void drawLine(int x1, int y1, int x2, int y2, Stage primStage, GraphicsContext gc)
{

    ArrayList<Integer[]> points = calculateLine(x1, y1, x2, y2, gc);
    PositionCounter position = new PositionCounter();

    int dy = Math.abs(y2 - y1);
    int dx = Math.abs(x2 - x1);
    int m = (dy >= dx) ? dy : dx;

    AtomicInteger counter = new AtomicInteger();
    Timeline animationTimeline = new Timeline(new KeyFrame(Duration.millis(20), (ActionEvent t) -> {
        position.setPosition(counter.getAndIncrement());
        fillPosition(points, gc, position.position);
    }));
    animationTimeline.setCycleCount(points.size());
    animationTimeline.play();

}