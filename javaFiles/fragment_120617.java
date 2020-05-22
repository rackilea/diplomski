import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DiceRoller {

    public static void main(String[] args) {
        new DiceRoller();
    }

    public DiceRoller() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Die());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Die extends JPanel {

        private int number = 1;

        public Die() {
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    number = (int) (Math.round((Math.random() * 5) + 1));
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setInitialDelay(0);
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(220, 220);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int width = getWidth();
            int height = getHeight();

            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, width, height);
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(10, 10, width - 20, height - 20, 50, 50);

            List<Shape> dots = new ArrayList<>(6);

            if (number == 1 || number == 3 || number == 5) {
                int x = (width - 20) / 2;
                int y = (height - 20) / 2;
                dots.add(new Ellipse2D.Float(x, y, 20, 20));
            }

            if (number == 2 || number == 3 || number == 4 || number == 5 || number == 6) {

                int x = ((width / 2) - 20) / 2;
                int y = ((height / 2) - 20) / 2;
                dots.add(new Ellipse2D.Float(x, y, 20, 20));
                dots.add(new Ellipse2D.Float(x + (width / 2), y + (height / 2), 20, 20));

            }

            if (number == 4 || number == 5 || number == 6) {

                int x = (width / 2) + (((width / 2) - 20) / 2);
                int y = ((height / 2) - 20) / 2;
                dots.add(new Ellipse2D.Float(x, y, 20, 20));
                dots.add(new Ellipse2D.Float(x - (width / 2), y + (height / 2), 20, 20));

            }

            if (number == 6) {

                int x = (((width / 2) - 20) / 2);
                int y = (height - 20) / 2;
                dots.add(new Ellipse2D.Float(x, y, 20, 20));
                dots.add(new Ellipse2D.Float(x + (width / 2), y, 20, 20));

            }

            for (Shape dot : dots) {
                g2d.fill(dot);
            }

            g2d.dispose();
        }
    }
}