BufferedImage bimg = ImageIO.read(new File("whatever.png"));

    // get the colour of the pixel at position (x, y)
    int col = bimg.getRGB(x, y);

    // decode red, green and blue components of colour if necessary
    int r = (col >> 16) & 0xff;
    int g = (col >> 8) & 0xff;
    int b = col & 0xff;