import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Landscape {

    List<Rectangle> rectangles;

    public Landscape() {
        rectangles = new ArrayList<Rectangle>();

        Random rand = new Random();
        int first = rand.nextInt((800 - 1) + 1) + 1;
        rectangles.add(new Rectangle(0, 800 - first, 1, first));

        int d = first % 2;
        if (d == 0)
            d = -1;

        for (int i = 1; i <= 800; i++) {
            int choose = rand.nextInt((1000 - 1) + 1) + 1;

            if (choose > 950) {
                d = -(d);
            }

            if (d == -1) {
                first += 1;
            } else {
                first -= 1;
            }

            rectangles.add(new Rectangle(i, 800 - first, 1, first));
        }
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(92, 163, 99));
        for (Rectangle r : rectangles) {
            g2d.fillRect(r.x, r.y, r.width, r.height);
        }
    }

} // End Landscape