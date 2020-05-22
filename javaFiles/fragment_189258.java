BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D g = image.createGraphics();
    this.paint(g);
    g.dispose();

    // File to save output Image
    File imageOut = new File("screenshot.png");
    try {
        ImageIO.write(image, "png", imageOut);
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }