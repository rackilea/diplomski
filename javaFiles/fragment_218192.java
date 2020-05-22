import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class CenteredImage extends JPanel {
    private static final String IMG_PATH = "https://upload.wikimedia.org/wikipedia/commons/"
            + "thumb/f/f8/Portrait_d%27une_Femme_%C3%A0_sa_Toilette%2C_by_Titian%2C_"
            + "from_C2RMF_retouched.jpg/300px-Portrait_d%27une_Femme_%C3%A0_sa_"
            + "Toilette%2C_by_Titian%2C_from_C2RMF_retouched.jpg";
    private BufferedImage img;

    public CenteredImage(BufferedImage img) {
        this.img = img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension prefSize = super.getPreferredSize();
        if (isPreferredSizeSet() || img == null) {
            return super.getPreferredSize();
        }
        return new Dimension(img.getWidth(), img.getHeight());
    }


    private static void createAndShowGui() {
        BufferedImage img = null;
        try {
            URL imgUrl = new URL(IMG_PATH);
            img = ImageIO.read(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        CenteredImage mainPanel = new CenteredImage(img);

        JFrame frame = new JFrame("CenteredImage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 650));
        frame.getContentPane().setLayout(new GridBagLayout());
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}