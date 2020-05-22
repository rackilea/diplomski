import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestClippedPanel {

    private static class ClippedPanel extends JPanel {

        private ImageIcon image;

        private List<Shape> shapes;

        public ClippedPanel() throws MalformedURLException {
            shapes = new ArrayList<Shape>();
            image = new ImageIcon(new URL("http://download.chip.eu//ii/163859211_4b28e1e687.jpg"));
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int x = random.nextInt(image.getIconWidth() - 1);
                int y = random.nextInt(image.getIconHeight() - 1);
                int w = random.nextInt(image.getIconWidth() - x) + 1;
                int h = random.nextInt(image.getIconHeight() - y) + 1;
                shapes.add(new Rectangle(x, y, w, h));
            }
            for (int i = 0; i < 10; i++) {
                int x = random.nextInt(image.getIconWidth() - 1);
                int y = random.nextInt(image.getIconHeight() - 1);
                int w = random.nextInt(image.getIconWidth() - x) + 1;
                int h = random.nextInt(image.getIconHeight() - y) + 1;
                shapes.add(new Ellipse2D.Double(x, y, w, h));
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image img = image.getImage();
            for (Shape shape : shapes) {
                ((Graphics2D) g).setClip(shape);
                g.drawImage(img, 0, 0, this);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(image.getIconWidth(), image.getIconHeight());
        }

    }

    protected void initUI() throws MalformedURLException {
        final JFrame frame = new JFrame(TestClippedPanel.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final ClippedPanel panel = new ClippedPanel();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new TestClippedPanel().initUI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}