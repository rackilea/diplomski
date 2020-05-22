import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                try {
                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new TestPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage background;
        private BufferedImage foreground;

        public TestPane() throws IOException {
            background = ImageIO.read(getClass().getResource("Background.png"));
            foreground = ImageIO.read(getClass().getResource("Foreground.png"));
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? new Dimension(200, 200) : new Dimension(background.getWidth(), background.getHeight());
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int x = 0;
            int y = 0;
            int width = getWidth();
            if (background != null) {
                x = (getWidth() - background.getWidth()) / 2;
                y = (getHeight() - background.getHeight()) / 2;
                width = background.getWidth();
                g2d.drawImage(background, x, y, this);
            }
            if (foreground != null) {
                x = x + width - foreground.getWidth();
                g2d.drawImage(foreground, x, y, this);
            }
            g2d.dispose();
        }

    }

}