package foo1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Surface {
    private int locX = 0;
    private int locY = 0;

    public Surface(int locX, int locY) {
        this.locX = locX;
        this.locY = locY;
    }

    public void runner() {
        locX = locX + 1;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillOval(locX, locY, 10, 10);
    }
}