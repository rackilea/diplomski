package explodingimage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Random;

public class FallingRectangle {
private static final int MAXWIDTH = 150;
private static final int MINWIDTH = 100;
private static final int MAXHEIGHT = 150;
private static final int MINHEIGHT = 100;
private final double MINX, MAXX, MINY, MAXY;
private static final Random rnd = new Random();
private Rectangle rectangle;
private Color color;
private int speed;

public FallingRectangle(Dimension bounds) {
    this.MAXX = bounds.getWidth() * 0.9;
    this.MINX = bounds.getWidth() * 0.1;
    this.MINY = 0;
    this.MAXY = bounds.getHeight();
    setup();
}

private void setup() {
    int x = (int) (rnd.nextInt((int) (MAXX - MINX)) + MINX);
    int y = 0;
    int w = rnd.nextInt(MAXWIDTH - MINWIDTH) + MINWIDTH;
    int h = rnd.nextInt(MAXHEIGHT - MINHEIGHT) + MINHEIGHT;
    int R = rnd.nextInt(256);
    int G = rnd.nextInt(256);
    int B = rnd.nextInt(256);
    speed = rnd.nextInt(3) + 1;

    rectangle = new Rectangle(x, y, w, h);
    color = new Color(R, G, B);
}

public Rectangle getRectangle() {
    return rectangle;
}

public Color getColor() {
    return color;
}

public void update() {
    int x = rectangle.x;
    int y = rectangle.y + speed;
    int w = rectangle.width;
    int h = rectangle.height;
    rectangle = new Rectangle(x, y, w, h);

    if (y >= MAXY)
        reset();
}

public void reset() {
    setup();
}

public void stop() {
    this.speed = 0;
}
}