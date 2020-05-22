import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class staffGUI extends JFrame {

    private JLabel imageLabel;

    private JPanel bxPanel = new JPanel();

    public staffGUI() {
        super("Staff Management");

        imageLabel = new JLabel();
        try {
            BufferedImage img = ImageIO.read(getClass().getResource("/staffdirectory/staff-directory.jpg"));
            imageLabel.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        bxPanel.setLayout(new GridLayout(1, 1));
        bxPanel.add(imageLabel);

        this.setLayout(new GridLayout(1, 1));
        this.add(bxPanel);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();

    }
}