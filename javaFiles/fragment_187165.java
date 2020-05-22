private Circle other = new Circle(100, 100, 10);
…
else {
    KeyValue end = new KeyValue(bullet.translateYProperty(), -800, new Interpolator() {
        @Override
        protected double curve(double t) {
            if (!Shape.intersect(bullet, other).getBoundsInLocal().isEmpty()) {
                System.out.println("Intersection");
            }
            return t;
        }
    });
    KeyFrame endF = new KeyFrame(Duration.seconds(10), end);
    timeline.getKeyFrames().addAll(endF);
}