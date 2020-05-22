import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class TestBackground {

    public static void main(String[] args) {
        new TestBackground();
    }

    public TestBackground() {
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

        public TestPane() {
            setLayout(new BorderLayout());

            try {
                BackgroundPane pane = new BackgroundPane(ImageIO.read(getClass().getResource("/shield02.png")));
                pane.setLayout(new GridBagLayout());
                pane.setBorder(new EmptyBorder(5, 5, 5, 5));
                GridBagConstraints gbc = new GridBagConstraints();

                JTextField jtf = new JTextField(2);
                jtf.setHorizontalAlignment(JTextField.CENTER);
                gbc.ipadx = 10;
                gbc.ipady = 10;
                gbc.gridy = 0;
                gbc.gridx = 0;
                jtf.setFocusable(false);
                pane.add(jtf, gbc);

                add(pane);
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

    }

    public class BackgroundPane extends JPanel {

        private BufferedImage img;

        public BackgroundPane(BufferedImage img) {
            this.img = img;
        }

        @Override
        public Dimension getPreferredSize() {
            return img != null ? new Dimension(img.getWidth(), img.getHeight()) : super.getPreferredSize();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                int x = (getWidth() - img.getWidth()) / 2;
                int y = (getHeight() - img.getHeight()) / 2;
                g.drawImage(img, x, y, this);
            }
        }

    }

}