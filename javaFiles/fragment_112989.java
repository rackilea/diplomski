private static void drawToArray(int[][] array2d, int x1, int y1, int x2, int y2) {
    int width = array2d[0].length; // width is columns and columns are second
    int height = array2d.length; // height is rows and rows are first

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = image.createGraphics();   // default color of image is 0 no need to paint background, just draw with color diferent than 0
    //g2d.setColor(Color.WHITE);               // default brush color is different than 0, expicitly setting is unnecesery
    //BasicStroke bs = new BasicStroke(1);
    //g2d.setStroke(bs);                       // default is 1 pixel expicitly setting is unnecesery

    g2d.drawLine(x1, y1, x2, y2); // paint line on image

    int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    for (int i = 0, row = 0, col = 0; i < pixels.length; i++) {
        array2d[row][col] = pixels[i] == 0 ? 0 : 1; // no performance difference vs if/else just readability
        //array2d[row][col] = pixels[i]; // if you write it like this you will be "painting" with '-1's instead of '1's and save one if/else
        col++;
        // if is more readable here no performance difference vs ternary
        if (col == width) {
            col = 0;
            row++;
        }
    }
    g2d.dispose();
}