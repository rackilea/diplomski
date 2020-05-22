package explodingimage;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Terrain {
private FallingRectangle rectangle;
private BufferedImage image;
private WritableRaster raster;
private int centerX, centerY;
private int[][] bitmap;
private int pixelSize;

public Terrain() {
    try {
        this.image = ImageIO.read(getClass().getResourceAsStream(
                "before.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    this.rectangle = new FallingRectangle(getBounds());
    this.raster = image.getRaster();
    setupBitmap();
}

public Dimension getBounds() {
    return new Dimension(image.getWidth(), image.getHeight() * 3);
}

public BufferedImage getImage() {
    return image;
}

public int getImageX() {
    return 0;
}

public int getImageY() {
    return image.getHeight() * 2;
}

public FallingRectangle getFallingRectangle() {
    return rectangle;
}

public void update() {
    rectangle.update();
    if (collidesWithRectangle())
        explode();
}

private void explode() {
    int explosionRadius = 100;
    double distance = 0;
    Rectangle r = new Rectangle(centerX - explosionRadius, centerY
            - explosionRadius, 2 * explosionRadius, 2 * explosionRadius);
    for (int x = 0; x < image.getWidth(); x++) {
        for (int y = 0; y < image.getHeight(); y++) {
            distance = Math.sqrt((x - centerX) * (x - centerX)
                    + (y - centerY) * (y - centerY));
            if (r.contains(x, y) && distance < explosionRadius) {
                raster.setPixel(x, y, new int[] { 255, 255, 255 });
            }
        }
    }
    rectangle.reset();
}

// Notice since the image we use as terrain/background doesn't cover the
// entire frame we have to use offsets, it covers the frame in width but not
// height
private boolean collidesWithRectangle() {
    int xOffset = 0;
    int yOffset = (int) (getBounds().getHeight() - image.getHeight());
    for (int x = 0; x < image.getWidth(); x++) {
        for (int y = 0; y < image.getHeight(); y++) {
            if (bitmap[x][y] == 0
                    && rectangle.getRectangle().contains(x + xOffset,
                            y + yOffset)) {
                centerX = x;
                centerY = y;
                return true;
            }
        }
    }
    return false;
}


// Set up the bitmap, check if pixel colorvalue is white or transparent
// 1 = pixel is solid, 0 pixel is transparent to objects
// Assuming length of 3 is RBG and length 4 is RBGA
private void setupBitmap() {
    bitmap = new int[image.getWidth()][image.getHeight()];
    for (int x = 0; x < image.getWidth(); x++) {
        for (int y = 0; y < image.getHeight(); y++) {
            int[] pixel = null;
            pixel = raster.getPixel(x, y, pixel);

            if (pixel.length == 3) {
                pixelSize = 3;
                if(pixel[0]==255 && pixel[1] ==255 && pixel[2]==255)
                    bitmap[x][y] = 1;
            }

            if (pixel.length == 4) {
                pixelSize = 4;
                if (pixel[3] == 0) {
                    bitmap[x][y] = 1;
                }
            }
        }
    }
}

}