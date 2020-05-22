import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class psw extends JPanel {
    String symbols = "~ ! @ # $ % ^ & * ( ) _ = + : ; < , > . ? / | \\ '";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame app = new JFrame();
                app.add(new psw());
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.pack();
                app.setVisible(true);

            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(30, 144, 255));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(new Color(255, 255, 255));
        g.drawRect(10, 10, 60, 50);
        g.drawLine(60, 50, 220, 20);
        g.drawString(symbols, 10, 150);
    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 450);
    }
}