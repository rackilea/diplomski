import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RotateWheel {

    public static void main(String[] args) {
        new RotateWheel();
    }

    public RotateWheel() {
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

        private float degrees = 0;

        public TestPane() {
            Timer timer = new Timer(40, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    degrees += 0.5f;
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int diameter = Math.min(getWidth(), getHeight());
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;

            g2d.setColor(Color.GREEN);
            g2d.drawOval(x, y, diameter, diameter);

            g2d.setColor(Color.RED);
            float innerDiameter = 20;

            Point p = getPointOnCircle(degrees, (diameter / 2f) - (innerDiameter / 2));
            g2d.drawOval(x + p.x - (int) (innerDiameter / 2), y + p.y - (int) (innerDiameter / 2), (int) innerDiameter, (int) innerDiameter);

            g2d.dispose();
        }

        protected Point getPointOnCircle(float degress, float radius) {

            int x = Math.round(getWidth() / 2);
            int y = Math.round(getHeight() / 2);

            double rads = Math.toRadians(degress - 90); // 0 becomes the top

            // Calculate the outter point of the line
            int xPosy = Math.round((float) (x + Math.cos(rads) * radius));
            int yPosy = Math.round((float) (y + Math.sin(rads) * radius));

            return new Point(xPosy, yPosy);

        }

    }

}