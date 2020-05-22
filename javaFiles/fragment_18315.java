import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Game extends JPanel {

    @Override
    public void paintComponent(final Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        Line2D line = new Line2D.Double(60, 90, 150, 100);
        g2.draw(line);

    }

    public static void main(final String args[]) {

        Game l = new Game();

        JFrame frame = new JFrame();

        frame.setSize(500, 500);
        frame.setTitle("Hello world");

        frame.setContentPane(l);

        frame.setVisible(true);

    }

}