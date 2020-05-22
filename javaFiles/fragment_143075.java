public static void main(String[] args) throws IOException {

    int x = 50, y = 50, w = 300, h = 200;

    // draw the "shadow"
    BufferedImage img = new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB);
    Graphics g = img.getGraphics();
    g.setColor(Color.BLACK);
    g.fillRect(x + 10, y + 10, w, h);

    // blur the shadow
    BufferedImageOp op = getBlurredOp();
    img = op.filter(img, null);

    // draw the box
    g = img.getGraphics();
    g.setColor(Color.RED);
    g.fillRect(x, y, w, h);

    // write it to disk
    ImageIO.write(img, "png", new File("test.png"));
}

private static BufferedImageOp getBlurredOp() {

    float[] matrix = new float[400];
    for (int i = 0; i < 400; i++)
        matrix[i] = 1.0f/400.0f;

    return new ConvolveOp(new Kernel(20, 20, matrix),
                          ConvolveOp.EDGE_NO_OP, null);
}