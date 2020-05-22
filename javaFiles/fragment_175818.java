import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ChickenDance {

    public static void main(String[] args) {
        new ChickenDance();
    }

    public ChickenDance() {
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

        private BufferedImage chicken;
        private int xPos;
        private int yPos;

        private int xDelta = 4;

        public TestPane() {
            try {
                chicken = ImageIO.read(getClass().getResource("/Chicken.png"));
            } catch (IOException ex) {
                Logger.getLogger(ChickenDance.class.getName()).log(Level.SEVERE, null, ex);
            }

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xPos += xDelta;
                    if (xPos + chicken.getWidth() > getWidth()) {
                        xPos = getWidth() - chicken.getWidth();
                        xDelta *= -1;
                    } else if (xPos < 0) {
                        xPos = 0;
                        xDelta *= -1;
                    }
                    yPos = (getHeight() - chicken.getHeight()) / 2;
                    repaint();
                }
            });
            if (chicken != null) {
                timer.start();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (chicken != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(chicken, xPos, yPos, this);
                g2d.dispose();
            }
        }
    }

}