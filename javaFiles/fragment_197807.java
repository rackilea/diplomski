package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class ImageProcessor1 implements Runnable {

  BufferedImage tempImg;
  public static int blackPixel = 0;

  public ImageProcessor1(final String path) throws Exception {
    final long start = System.nanoTime();

    tempImg = ImageIO.read(new File(path));
    // Use tracing, profiling and sampling to proof performance issues and fixes
    System.out.println("ImageIO took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start)
        + " ms.");
  }

  @Override
  public void run() {
    long start = System.nanoTime();
    final int height = tempImg.getHeight();
    System.out.println("Getting height '" + height + "' took "
        + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " ms.");


    start = System.nanoTime();
    final int width = tempImg.getWidth();
    System.out.println("Getting width '" + width + "' took "
        + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " ms.");

    start = System.nanoTime();

    // reuse variables
    int argb;
    int red;
    int green;
    int blue;

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        // HOT LOOP. Do as little as possible. No println calls!
        argb = tempImg.getRGB(i, j);

        // inline all method calls
        red = argb >> 16 & 0xff; // red
        green = argb >> 8 & 0xff; // green
        blue = argb & 0xff; // blue

        if (red < 125 && red > 105 && green < 125 && green > 105 && blue < 125 && blue > 105) {
          blackPixel += 1;
        }
      }
    }
    System.out.println("Iterating pixels took "
        + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " ms.");
  }

  public static void main(final String[] args) throws Exception {
    new ImageProcessor1("big.jpg").run();
    System.out.println("Number of blackpixels = " + blackPixel);
  }

}