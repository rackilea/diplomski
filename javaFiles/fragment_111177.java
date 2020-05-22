import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setVisible(true);

        frame.add(new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                double alpha = Math.toRadians(5);
                double factor = 1 / (Math.sin(alpha) + Math.cos(alpha));
                double size = 200;

                g2d.translate(size, size);

                for (int i = 0; i < 20; i++) {
                    g2d.setColor(i % 2 == 0 ? Color.black : Color.green);

                    int intSize = (int) Math.round(size);

                    g2d.fillRect(-intSize / 2, -intSize / 2, intSize, intSize);

                    size = size * factor;

                    g2d.rotate(alpha);
                }
            }
        });
    }
}