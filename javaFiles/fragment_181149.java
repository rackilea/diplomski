import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestImage {

    public static void main(String[] args) {
        new TestImage();
    }

    public static final String IMAGE_PATH = "C:\\Users\\shane\\Dropbox\\Ponies\\28490 - animated gif rainbow_dash_Small.gif";

    public TestImage() {
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
                frame.setLayout(new GridLayout(1, 2));
                frame.add(new JLabel(new ImageIcon(IMAGE_PATH)));
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private ImageIcon img;
        private float degrees;

        public TestPane() {

            img = new ImageIcon(IMAGE_PATH);
            Timer timer = new Timer(16, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    degrees += 1;
                    repaint();
                }
            });
            timer.start();

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(img.getIconWidth(), img.getIconHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int x = getWidth() / 2;
            int y = getHeight() / 2;
            g2d.setTransform(AffineTransform.getRotateInstance(Math.toRadians(degrees), x, y));
            x = (getWidth() - img.getIconWidth()) / 2;
            y = (getHeight() - img.getIconHeight()) / 2;
            img.paintIcon(this, g2d, x, y);
            g2d.dispose();
        }

    }

}