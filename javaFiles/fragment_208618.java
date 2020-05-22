scene.setOnKeyPressed(e -> {
    switch (e.getCode()) {
    case DOWN:
        circle.setCenterY(circle.getCenterY() + 10);
        break;
    case UP:
        circle.setCenterY(circle.getCenterY() - 10);
        break;
    case LEFT:
        circle.setCenterX(circle.getCenterX() - 10);
        break;
    case RIGHT:
        circle.setCenterX(circle.getCenterX() + 10);
        break;
    }
});