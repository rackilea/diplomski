// Initialize Color[][] however you were already doing so.
Color[][] image;

// Initialize BufferedImage, assuming Color[][] is already properly populated.
BufferedImage bufferedImage = new BufferedImage(image.length, image[0].length,
        BufferedImage.TYPE_INT_RGB);

// Set each pixel of the BufferedImage to the color from the Color[][].
for (int x = 0; x < image.length; x++) {
    for (int y = 0; y < image[x].length; y++) {
        bufferedImage.setRGB(x, y, image[x][y].getRGB());
    }
}