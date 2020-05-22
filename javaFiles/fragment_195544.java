import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Smile {

    public static void main(String[] args) {
        new Smile();
    }

    public Smile() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawSmiley(g, 25, 25, 100);
        }

        public void drawSmiley(Graphics g, int x, int y, int s) {
            Graphics copy = g.create();
            copy.translate(x, y);
            copy.setColor((Color.YELLOW));
            copy.fillOval(0, 0, s, s);
            copy.setColor((Color.blue));
            copy.fillOval((int) (1 + s * .3), (int) (1 + s * .3), (int) (s * .10), (int) (s * .10));
            copy.fillOval((int) ((1 + s * .7) - (s * .10)), (int) (1 + s * .3), (int) (s * .10), (int) (s * .10));

            double width = s * 0.8;
            double height = s * 0.8;

            copy.drawArc((int)((s - width) / 2d), (int)((s - height) / 2d), (int)width, (int)height, 0, -180);
            copy.dispose();
        }
    }

}