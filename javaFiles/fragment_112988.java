private static void drawToArray(int[][] array2d, int x1, int y1, int x2, int y2) {
    int width = array2d[0].length; // width is columns and columns are second
    int height = array2d.length; // height is rows and rows are first

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = image.createGraphics();
    g2d.setBackground(Color.WHITE);
    g2d.fillRect(0, 0, width, height);  // paint background white
    g2d.setColor(Color.BLACK);
    BasicStroke bs = new BasicStroke(1); // set black brush to size 1 (1 pixel)
    g2d.setStroke(bs);

    g2d.drawLine(x1, y1, x2, y2); // paint line on image

    // fill array with values, check entire image
    for (int row = 0; row < height; row++) {
        for (int column = 0; column < width; column++) {
            int clr = image.getRGB(row,column); // get color of pixel at position
            if (clr == Color.WHITE.getRGB()) { // white is -1
                array2d[row][column] = 0;
            } else {
                array2d[row][column] = 1;
            }
        }
    }
    g2d.dispose();
    // returning array is not necesery I am editing the array2d variable passed in
}