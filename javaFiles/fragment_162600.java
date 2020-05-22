Background createBackground() {
    double width = 200;
    double height = 200;

    Canvas canvas = new Canvas(width, height);
    GraphicsContext g = canvas.getGraphicsContext2D();

    double[] x;
    double[] y;

    g.setFill(Color.RED);

    // Left triangle
    x = new double[] { 0, 0, width / 2 };
    y = new double[] { 0, height, height / 2 };
    g.fillPolygon(x, y, x.length);

    // Right triangle
    x = new double[] { width, width, width / 2 };
    g.fillPolygon(x, y, x.length);

    g.setFill(Color.DARKGREEN);

    // Top triangle
    x = new double[] { 0, width, width / 2 };
    y = new double[] { 0, 0, height / 2 };
    g.fillPolygon(x, y, x.length);

    // Bottom triangle
    y = new double[] { height, height, height / 2 };
    g.fillPolygon(x, y, x.length);

    Image image = canvas.snapshot(null, null);

    return new Background(
        new BackgroundImage(image, null, null, null, null));
}