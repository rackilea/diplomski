try {
    BufferedImage off_Image = 
    new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = off_Image.createGraphics(); 
    for (int i= 0; i< NumberOfRow; i++) {
        for (int j= 0; j< NumberOfColumn; j++) {
            g2.setColor(new Color(....)); // here convert the value in image[i][j] to aRGB
            g2.draw(new Rectangle(i, j, 1, 1);
        }
    }
    File outputfile = new File("saved.png");
    ImageIO.write(bi, "png", outputfile);
} catch (IOException e) {
    // handle exception
}