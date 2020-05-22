public void myJob(Shape shape) {
    if (shape instanceof Circle) {
        Circle circle = (Circle) shape;
        // Some Circle job
        int radius = circle.getRadius();
    }
}