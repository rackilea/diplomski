import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Spelplan extends javax.swing.JFrame {

    public static BufferedImage image;
    private String imagePath = "https://upload.wikimedia.org/wikipedia/commons/3/3f/Crystal_Project_bug.png";

    public Spelplan() {
        try {
            URL url = new URL(imagePath);
            image = ImageIO.read(url);
        }
        catch(IOException e) {
            System.out.println("Image not found");
        }

        add(new GraphicsPanel(image));
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        new Spelplan();
    }
}

class GraphicsPanel extends JPanel {

    private BufferedImage image;

    public GraphicsPanel(BufferedImage image){
        this.image = image;
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}