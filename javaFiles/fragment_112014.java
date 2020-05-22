package image;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Random;

public class ScreenRenderer {

    private int width, height;
    /*public int[] pixels;*/
    private WritableRaster raster;
    private int[] pixels;
    private Random rand = new Random();

    public ScreenRenderer(BufferedImage image) {
        /*this.width = width;
        this.height = height;*/
        //this.pixels = new int[width * height];
        this.raster = image.getRaster();
        this.width = raster.getWidth();
        this.height = raster.getHeight();

        pixels = new int[raster.getWidth() * raster.getHeight() * raster.getNumBands()];
        System.out.printf("%d %d %d", width, height, pixels.length);
    }

    public void renderScreen() {
        int seed = rand.nextInt();
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = i * seed;
        }
        raster.setPixels(0, 0, width, height, pixels);
    }

}