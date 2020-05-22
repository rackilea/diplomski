// TODO: replace circle field with ellipse field of type Ellipse
ellipse = new Ellipse();
ellipse.setStrokeWidth(1.0);
ellipse.setFill(Color.TRANSPARENT);
ellipse.setStroke(Color.BLACK);

mousePressed = event -> {
    startingPosX = event.getX();
    startingPosY = event.getY();
    ellipse.setCenterX(startingPosX);
    ellipse.setCenterY(startingPosY);
    ellipse.setRadiusX(0);
    ellipse.setRadiusY(0);
    borderPane.getChildren().add(ellipse);
};

mouseReleased = event -> {
    borderPane.getChildren().remove(ellipse);
    double width = Math.abs(event.getX() - startingPosX);
    double height = Math.abs(event.getY() - startingPosY);
    graphicsContext.setStroke(Color.BLACK);
    graphicsContext.strokeOval(Math.min(startingPosX, event.getX()), Math.min(startingPosY, event.getY()), width, height);
    removeListeners();
};

mouseDragged = event -> {
    ellipse.setCenterX((event.getX() + startingPosX) / 2);
    ellipse.setCenterY((event.getY() + startingPosY) / 2);
    ellipse.setRadiusX(Math.abs((event.getX() - startingPosX) / 2));
    ellipse.setRadiusY(Math.abs((event.getY() - startingPosY) / 2));
};