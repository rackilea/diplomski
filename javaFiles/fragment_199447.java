import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SeamCarving {

    public static void main(String[] args) {
        new SeamCarving();
    }

    public SeamCarving() {
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

        private BufferedImage input;
        private BufferedImage[] toPaint;

        public TestPane() {
            try {
                input = ImageIO.read(new File("C:\\hold\\thumbnails\\2005-09-29-3957.jpeg"));
                toPaint = new BufferedImage[1];
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            setLayout(new GridBagLayout());
            JButton startButton = new JButton("Start");
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BufferedImage out = input;
                    out = input; //deleteVerticalSeam(out);
                    toPaint[0] = out;
                    repaint();
                    System.out.println("Do Something Clicked");
                }
            });
            add(startButton);
        }

        @Override
        public Dimension getPreferredSize() {
            return input == null ? new Dimension(400, 400) : new Dimension(input.getWidth(), input.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (toPaint[0] != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(input, 0, 0, this);
                g2d.dispose();
            }
        }
    }

}