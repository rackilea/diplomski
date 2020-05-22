public static BufferedImage applyMask(BufferedImage sourceImage, BufferedImage maskImage, int method) {

    BufferedImage maskedImage = null;
    if (sourceImage != null) {

        int width = maskImage.getWidth();
        int height = maskImage.getHeight();

        maskedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D mg = maskedImage.createGraphics();

        int x = (width - sourceImage.getWidth()) / 2;
        int y = (height - sourceImage.getHeight()) / 2;

        mg.drawImage(sourceImage, x, y, null);
        mg.setComposite(AlphaComposite.getInstance(method));

        mg.drawImage(maskImage, 0, 0, null);

        mg.dispose();
    }

    return maskedImage;

}