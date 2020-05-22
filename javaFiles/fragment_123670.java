import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JApplet;

public class House_JM extends JApplet {

    @Override
    public void paint(Graphics g) {
        Graphics2D page = (Graphics2D)g;

        int w = getWidth();
        int h = getHeight();

        Rectangle2D ground = new Rectangle2D.Double(
            0, h * 0.8, w, h * 0.2);

        Rectangle2D bg = new Rectangle2D.Double(
            0, 0, w, h * 0.8);

        Rectangle2D walls = new Rectangle2D.Double(
            bg.getWidth() * 0.5 - bg.getWidth() * 0.1, 
            bg.getHeight() * 0.5,
            bg.getWidth() * 0.4, 
            h * 0.4);

        page.setColor(Color.green);
        page.fill(ground);
        page.setColor(Color.blue);
        page.fill(bg);
        page.setColor(Color.red);
        page.fill(walls);

        System.out.println(bg.getHeight());
    }
}