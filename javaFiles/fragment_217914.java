import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DrawCircle extends JFrame {

    JPanel panel;

    public DrawCircle(String title, int width, int height) {
        this.setTitle(title);
        this.setSize(width, height);
        this.setLocationRelativeTo(null); // Center JFrame
        this.setLayout(new MigLayout("fill"));  // Download external jar
        this.panel = new DrawOval();
        this.add(panel, "dock center");  // Link: http://www.miglayout.com/
        this.setVisible(true);
    }

    public class DrawOval extends JPanel {

            Color color = new Color(1, 1, 1);

        public DrawOval() {

        }

        @Override
        public void paint(Graphics g) {
            g.setColor(color.RED);
            g.fillOval(0, 0, this.getWidth(), this.getHeight());
        }
    }

}