BufferedImage singlePixelImage = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
    Color transparent = new Color(0, 0, 0, 0);
    singlePixelImage.setRGB(0, 0, transparent.getRGB());

    File file = new File("pixel.png");
    try {
        ImageIO.write(singlePixelImage, "png", file);
    } catch (IOException e) {
        // TODO Auto-generated catch block
    }