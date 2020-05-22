import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class WelcomePanel extends JPanel {

    public WelcomePanel(Image backGround, Image foreGround) {
        JLabel backGroundLabel = new JLabel(new ImageIcon(backGround));
        JLabel foreGroundLabel = new JLabel(new ImageIcon(foreGround));

        // if you want the welcome image away from the edge, then give
        // backGroundLabel an empty border with appropriate insets. For example:
        // backGroundLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        backGroundLabel.setLayout(new FlowLayout());
        backGroundLabel.add(foreGroundLabel);
    }

    private static void createAndShowGui() {
        String backImgName = "images/domino.png";
        String foreImgName = "images/welcome.png";
        URL backImageURL = WelcomePanel.class.getResource(backImgName);
        URL foreImageURL = WelcomePanel.class.getResource(foreImgName);
        Image backGroundImg = null;
        Image foreGroundImg = null;
        if (backImageURL != null && foreImageURL != null) {
            try {
                backGroundImg = ImageIO.read(backImageURL);
                foreGroundImg = ImageIO.read(foreImageURL);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

        WelcomePanel mainPanel = new WelcomePanel(backGroundImg, foreGroundImg);

        // or perhaps better to use a JDialog
        JFrame frame = new JFrame("Image On Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}