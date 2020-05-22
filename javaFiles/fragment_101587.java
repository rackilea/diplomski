import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
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

        private BufferedImage buffer;

        public TestPane() {
            setBackground(Color.RED);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        public void invalidate() {
            buffer = null;
            super.invalidate();
        }

        protected BufferedImage getBoard() {

            if (buffer == null) {

                int width = getWidth() - 20;
                int height = getHeight() - 20;
                buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = buffer.createGraphics();
                g2d.setColor(Color.BLUE);
                g2d.fillRect(0, 0, width, height);

                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
                g2d.setColor(new Color(0, 0, 0, 0));
                int cellWidth = width / 4;
                int cellHeight = height / 4;

                for (int row = 0; row < 4; row++) {
                    int yPos = (row * cellHeight);
                    for (int col = 0; col < 4; col++) {
                        int xPos = (col * cellWidth);
                        g2d.fill(new Ellipse2D.Double(xPos + 2, yPos + 2, cellWidth - 4, cellHeight - 4));
                    }
                }
                g2d.dispose();

            }

            return buffer;

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            BufferedImage buffer = getBoard();
            int x = (getWidth() - buffer.getWidth()) / 2;
            int y = (getHeight() - buffer.getHeight()) / 2;
            g2d.drawImage(buffer, x, y, this);
            g2d.dispose();
        }

    }

}