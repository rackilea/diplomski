import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

public class TestTwoPanels {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                JPanel panel = new JPanel();
                PanelTwo panelTwo = new PanelTwo();
                PanelOne panelOne = new PanelOne(panelTwo);

                JSplitPane split = new JSplitPane(
                        JSplitPane.HORIZONTAL_SPLIT, panelOne, panelTwo);
                panel.add(split);


                JFrame frame = new JFrame("Test Graphics");
                frame.add(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private static class PanelOne extends JPanel {

        Dimension size;
        BufferedImage image;
        PanelTwo panelTwo;

        public PanelOne(PanelTwo panelTwo) {
            this.panelTwo = panelTwo;
            try {
                URL url = new URL("http://swoo.co.uk/content/images/icons/stackoverflow.png");
                image = ImageIO.read(url);
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panelTwo.setImage(PanelOne.this);
            panelTwo.repaint();

        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(image, 0, 0, this);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(250, 250);
        }
    }

    private static class PanelTwo extends JPanel {

        BufferedImage bi;

        public PanelTwo() {
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }

        public void setImage(BufferedImage image) {
            this.bi = image;
        }

        private void setImage(JPanel panel) {
            Dimension d = panel.getPreferredSize();
            int w = (int)d.getWidth();
            int h =(int)d.getHeight();
            System.out.println(d);
            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bi.createGraphics();
            panel.paint(g);
            g.dispose();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bi, 25, 25, 225, 225, 50, 50, 175, 175, this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(250, 250);
        }
    }
}