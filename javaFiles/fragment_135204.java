import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestScrollPanePos {

    public static void main(String[] args) {
        new TestScrollPanePos();
    }

    public TestScrollPanePos() {
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
                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage bg;
        private Point point;

        public TestPane() {
            try {
                bg = ImageIO.read(new File("/path/to/image));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            addMouseMotionListener(new MouseAdapter() {

                @Override
                public void mouseMoved(MouseEvent e) {
                    System.out.println(e.getPoint());
                    point = e.getPoint();
                    repaint();
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return bg == null ? new Dimension(200, 200) : new Dimension(bg.getWidth(), bg.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bg != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth() - bg.getWidth()) / 2;
                int y = (getHeight()- bg.getHeight()) / 2;
                g2d.drawImage(bg, x, y, this);
                if (point != null) {
                    FontMetrics fm = g2d.getFontMetrics();
                    g2d.setColor(Color.BLACK);
                    g2d.drawString(point.x + "x" + point.y, point.x, point.y - fm.getHeight() + fm.getAscent());
                }
                g2d.dispose();
            }
        }
    }

}