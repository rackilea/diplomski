public void seeBMPImage(String BMPFileName) throws IOException {
    BufferedImage image = ImageIO.read(getClass().getResource(BMPFileName));

    int[][] array2D = new int[image.getWidth()][image.getHeight()];

    for (int xPixel = 0; xPixel < image.getWidth(); xPixel++)
        {
            for (int yPixel = 0; yPixel < image.getHeight(); yPixel++)
            {
                int color = image.getRGB(xPixel, yPixel);
                if (color==Color.BLACK.getRGB()) {
                    array2D[xPixel][yPixel] = 1;
                } else {
                    array2D[xPixel][yPixel] = 0; // ?
                }
            }
        }
    }