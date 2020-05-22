public void moveCircle(Circle circle, Scene scene) {
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                circle.setCenterX(random((int) scene.getX()));
                circle.setCenterY(random((int) scene.getY()));
            });
        }
    }, 1000, 1000);
}