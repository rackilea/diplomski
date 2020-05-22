import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestButton {

    public static void main(String[] args) {
        new TestButton();
    }

    private BufferedImage master;

    public TestButton() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                try {
                    master = ImageIO.read(new File("C:\\svg\\Revert 256x256.png"));

                    JButton btn = new JButton() {

                        @Override
                        public Dimension getPreferredSize() {
                            return new Dimension(90, 50);
                        }

                    };
                    btn.addComponentListener(new ComponentAdapter() {

                        @Override
                        public void componentResized(ComponentEvent e) {
                            JButton btn = (JButton) e.getComponent();
                            Dimension size = btn.getSize();
                            Insets insets = btn.getInsets();
                            size.width -= insets.left + insets.right;
                            size.height -= insets.top + insets.bottom;
                            if (size.width > size.height) {
                                size.width = -1;
                            } else {
                                size.height = -1;
                            }
                            Image scaled = master.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
                            btn.setIcon(new ImageIcon(scaled));
                        }

                    });

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(btn);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

}