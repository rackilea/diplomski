import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class PixelArtSizeFinder {
    public static void main(String[] args) throws IOException {
        File imageFile = new File("pixel_boat.png");
        BufferedImage image = ImageIO.read(imageFile);

        int w = image.getWidth();
        int h = image.getHeight();
        System.out.format("Size: %dx%d%n", w, h);

        Raster data = image.getData();

        int objectsFound = 0;
        int startObjectWidth = 0;
        int endObjectWidth = 0;
        boolean scanningObject = false;
        for (int x = 0; x < w; x++) {

            boolean verticalLineContainsOnlyTransparentOrBorder = true;
            for (int y = 0; y < h; y++) {
                int[] pixel = data.getPixel(x, y, new int[4]);
                if (isOther(pixel)) {
                    verticalLineContainsOnlyTransparentOrBorder = false;
                }
            }

            if (verticalLineContainsOnlyTransparentOrBorder) {
                if (scanningObject) {
                    endObjectWidth = x;
                    System.out.format("Object %d: %d-%d (%dpx)%n",
                            objectsFound,
                            startObjectWidth,
                            endObjectWidth,
                            endObjectWidth - startObjectWidth);
                } else {
                    objectsFound++;
                    startObjectWidth = x;
                }
                scanningObject ^= true; //toggle
            }
        }
    }

    private static boolean isTransparent(int[] pixel) {
        return pixel[3] == 0;
    }

    private static boolean isBorder(int[] pixel) {
        return pixel[0] == 0 && pixel[1] == 187 && pixel[2] == 255 && pixel[3] == 255;
    }

    private static boolean isOther(int[] pixel) {
        return !isTransparent(pixel) && !isBorder(pixel);
    }
}