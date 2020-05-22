import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FrameIconTest {

    public static void main(String[] args) {
        new FrameIconTest();
    }

    public FrameIconTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");

                try {
                    List<Image> icons = new ArrayList<Image>(5);
                    icons.add(ImageIO.read(getClass().getResource("/resources/FrameIcon16x16.png")));
                    icons.add(ImageIO.read(getClass().getResource("/resources/FrameIcon24x24.png")));
                    icons.add(ImageIO.read(getClass().getResource("/resources/FrameIcon32x32.png")));
                    icons.add(ImageIO.read(getClass().getResource("/resources/FrameIcon64x64.png")));
                    icons.add(ImageIO.read(getClass().getResource("/resources/FrameIcon128x128.png")));
                    frame.setIconImages(icons);
                } catch (IOException exp) {
                    exp.printStackTrace();
                    // Log the problem through your applications logger...
                }

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JLabel("Frame with icon"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}