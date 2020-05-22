import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Draw2D extends JFrame {
    public Draw2D() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new DrawPane(), BorderLayout.CENTER);
        pack();
    }

    public static void main(String[] args) {
        Draw2D drawing = new Draw2D();
        drawing.setVisible(true);
    }
}

class DrawPane extends JComponent {
    public DrawPane() {
        setPreferredSize(new Dimension(640, 640));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // use anti-aliasing for smooth lines
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // move origin to center
        g2.translate(getWidth() / 2, getHeight() / 2);

        // scale as you need. Using negative y so that y points upward
        // note that non-square window sizes will cause a different aspect ratio,
        // you probably want to use Math.min(width, height) or something
        g2.scale(getWidth() / 2, -getHeight() / 2);

        // set color and thickness
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(0.001f));

        // draw coordinate lines
        g2.draw(new Line2D.Float(-1f, 0f, 1.0f, 0f));
        g2.draw(new Line2D.Float(0, -1.0f, 0.0f, 1.0f));

        // draw a vector
        g2.draw(new Line2D.Float(0f, 0f, 0.25f, 0.25f));
    }
}