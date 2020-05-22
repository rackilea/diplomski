import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedImage crop = new Test().crop(0.8509);
        System.out.println(crop.getWidth() + "x" + crop.getHeight());
        ImageIO.write(crop, "jpg", new File("Square.jpg"));
    }

    public BufferedImage crop(double amount) throws IOException {
        BufferedImage originalImage = ImageIO.read(Test.class.getResource("Cat.jpg"));
        int height = originalImage.getHeight();
        int width = originalImage.getWidth();

        int targetWidth = (int)(width * amount);
        int targetHeight = (int)(height * amount);
        // Coordinates of the image's middle
        int xc = (width - targetWidth) / 2;
        int yc = (height - targetHeight) / 2;

        // Crop
        BufferedImage croppedImage = originalImage.getSubimage(
                        xc, 
                        yc,
                        targetWidth, // widht
                        targetHeight // height
        );
        return croppedImage;
    }

}