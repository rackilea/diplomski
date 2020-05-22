import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DownWithNullLayouts {

    public static void main(String[] args) {
        new DownWithNullLayouts();
    }

    public DownWithNullLayouts() {
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

        private Font titlefont;
        private BufferedImage bi;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(30, 0, 0, 0);
            add(new JButton("Play"), gbc);
            try {
                bi = ImageIO.read(...);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            titlefont = UIManager.getFont("Label.font");
            setBackground(Color.BLACK);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int x = (getWidth() - bi.getWidth()) / 2;
            int y = (getHeight()- bi.getHeight()) / 2;
            g2d.drawImage(bi, x, y, this);
            g2d.setFont(titlefont);
            g2d.setColor(Color.WHITE);
            g2d.drawString("dont steal my game idea plz", 25, 100);
            g2d.dispose();
        }

    }

}