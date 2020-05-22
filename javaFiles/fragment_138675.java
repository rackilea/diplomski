// create image
BufferedImage image = new BufferedImage(
     WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB
);

// set content
image.setRGB(0, 0, WIDTH, HEIGHT, rgbArray, 0, WIDTH);

// save it
File outputfile = new File("Screenshot.png");
try {
    ImageIO.write(image, "png", outputfile);
} catch (IOException e) {
    e.printStackTrace();
}