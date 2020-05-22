import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestMouseClicked {

    public static void main(String[] args) {
        new TestMouseClicked();
    }

    public TestMouseClicked() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JLabel clickMe;
        private Point clickPoint;

        public TestPane() {
            setLayout(new GridBagLayout());
            clickMe = new JLabel("Click me") {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.MAGENTA);
//                    paintPoint(g, clickPoint);
                }
            };
            add(clickMe);
            clickMe.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clickPoint = e.getPoint();
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            paintPoint(g, clickPoint);
            if (clickPoint != null) {
                g.setColor(Color.BLUE);
                // Convert the point from clickMe coordinate space to local coordinate space
                paintPoint(g, SwingUtilities.convertPoint(clickMe, clickPoint, this));
            }
        }

        protected void paintPoint(Graphics g, Point clickPoint) {
            if (clickPoint != null) {
                int size = 4;
                g.fillOval(clickPoint.x - size, clickPoint.y - size, size * 2, size * 2);
            }
        }
    }
}