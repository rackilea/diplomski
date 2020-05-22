public static void main(String[] args) {
    Shape shape = new Circle(100);
    PathTransition pt = new PathTransition(Duration.ONE, shape, new Circle());
    long t0 = System.currentTimeMillis();
    pt.playFromStart(); // force initialization
    pt.stop();
    for (double frac = 0.0; frac <= 1.0; frac += 0.05) {
        pt.interpolate(frac);
        System.out.println(pt.getNode().getTranslateX() + " " + pt.getNode().getTranslateY());
    }
    long t1 = System.currentTimeMillis();
    System.out.println("Evaluation took: " + (t1 - t0) + "ms");
}