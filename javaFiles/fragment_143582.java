public void save(){
    try {
        BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(image, 0, 0, null);
        javax.imageio.ImageIO.write(bimage , "PNG", new File("test.png"));
        bGr.dispose();
    } catch (Exception ex) {
        Logger.getLogger(PadDraw.class.getName()).log(Level.SEVERE, null, ex);
    }
}