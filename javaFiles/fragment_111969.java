package com.ggl.rgbdisplay.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class RGBDisplayModel {

    private BufferedImage originalImage;
    private BufferedImage redImage;
    private BufferedImage greenImage;
    private BufferedImage blueImage;

    public BufferedImage getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(BufferedImage originalImage) {
        this.originalImage = originalImage;
        this.redImage = createColorImage(originalImage, 0xFFFF0000);
        this.greenImage = createColorImage(originalImage, 0xFF00FF00);
        this.blueImage = createColorImage(originalImage, 0xFF0000FF);
    }

    public BufferedImage getRedImage() {
        return redImage;
    }

    public BufferedImage getGreenImage() {
        return greenImage;
    }

    public BufferedImage getBlueImage() {
        return blueImage;
    }

    public static BufferedImage createTestImage() {
        BufferedImage bufferedImage = new BufferedImage(200, 200,
                BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedImage.getGraphics();

        for (int y = 0; y < bufferedImage.getHeight(); y += 20) {
            if (y % 40 == 0) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(0, y, bufferedImage.getWidth(), 20);
        }

        g.dispose();
        return bufferedImage;
    }

    private BufferedImage createColorImage(BufferedImage originalImage, int mask) {
        BufferedImage colorImage = new BufferedImage(originalImage.getWidth(),
                originalImage.getHeight(), originalImage.getType());

        for (int x = 0; x < originalImage.getWidth(); x++) {
            for (int y = 0; y < originalImage.getHeight(); y++) {
                int pixel = originalImage.getRGB(x, y) & mask;
                colorImage.setRGB(x, y, pixel);
            }
        }

        return colorImage;
    }

}