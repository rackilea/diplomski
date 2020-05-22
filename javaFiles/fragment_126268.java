public void moveCircle(Circle circle, Scene scene) {
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
        circle.setCenterX(random((int) scene.getX()));
        circle.setCenterY(random((int) scene.getY()));
    }));
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
}