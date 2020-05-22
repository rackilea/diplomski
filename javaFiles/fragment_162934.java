BufferedImage images = ImageIO.read(new File("image.jpg")); 
    int type = (images.getTransparency() == Transparency.OPAQUE)
            ? BufferedImage.TYPE_INT_RGB
            : Buffenter code hereeredImage.TYPE_INT_ARGB;
    BufferedImage finalImage = images;
    int w = 40;
    int h = 40;
    BufferedImage resizedImage = new BufferedImage(w, h, type);
    Graphics2D g2 = resizedImage.createGraphics();
    g2.drawImage(finalImage, 0, 0, null);
    g2.dispose();
    finalImage = resizedImage;