import javax.imageio.ImageIO;

// ...

BufferedImage image = ...;

ImageIO.write(image, "png", new File("output.png"));