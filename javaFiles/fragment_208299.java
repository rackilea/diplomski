import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestScrollPane {

    public static void main(String[] args) {
        new TestScrollPane();
    }

    public TestScrollPane() {
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
                frame.add(new JScrollPane(new TestPane()));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private List<Point> points;
        private JPopupMenu pm;

        public TestPane() {
            pm = new JPopupMenu();
            pm.add(new JLabel("Suprise"));
            points = new ArrayList<>(3);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Point p = e.getPoint();
                    points.clear();
                    points.add(p);
                    // View port
                    Container parent = getParent();
                    Point pp = SwingUtilities.convertPoint(TestPane.this, p, parent);
                    points.add(pp);
                    // ScrollPane...
                    parent = parent.getParent();
                    Point ppp = SwingUtilities.convertPoint(TestPane.this, p, parent);
                    points.add(ppp);

                    pm.show(TestPane.this, p.x, p.y);

                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1000, 1000);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (points.size() == 3) {
                g2d.setColor(Color.RED);
                Point p = points.get(0);
                g2d.fillOval(p.x - 2, p.y - 2, 4, 4);

                g2d.setColor(Color.GREEN);
                p = points.get(1);
                g2d.fillOval(p.x - 2, p.y - 2, 4, 4);

                g2d.setColor(Color.BLUE);
                p = points.get(2);
                g2d.fillOval(p.x - 2, p.y - 2, 4, 4);
            }
            g2d.dispose();
        }
    }
}