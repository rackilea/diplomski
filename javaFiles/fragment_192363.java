import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class StarField extends JFrame {
    public int size = 400;

    public Star[] stars = new Star[50];

    public static void main(String[] args) {
        StarField field = new StarField();
        field.setVisible(true);
    }

    public StarField() {
        this.setSize(size, size);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // usually you should use a normal layout manager, but for your task we need null
        getContentPane().setLayout(null);
        for (int i = 0; i < stars.length; i++) {
            int x = (int) (Math.random() * size);
            int y = (int) (Math.random() * size);
            stars[i] = new Star(x, y);
            this.add(stars[i]);
        }
    }

    public class Star extends JComponent {

        private final Color color = Color.YELLOW;

        public Star(int x, int y) {
            // need to set the correct coordinates
            setBounds(x, y, 8, 8);
        }

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(color);
            g.fillOval(0, 0, getWidth(), getHeight());
        }
    }
}