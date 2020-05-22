public void handle(long currentNanoTime) {
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

    gc.setFill(Color.BLUE);
    gc.fillArc(150, 150, 100, 100, 0, 240, ArcType.ROUND);
}