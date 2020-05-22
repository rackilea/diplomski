import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwagFrame extends JPanel {
    public SwagFrame() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage bg = null;

        try {
            bg = ImageIO.read(new File("icons/stacko/stackoverflow1.png"));
        } catch (IOException e) {
            System.out.println("Swag not turned on");
            //System.exit(-1);
        }


        g.drawImage(bg, 0, 0, this); // exception here
        g.setColor(Color.GREEN);
        g.fillOval(250, 250, 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new SwagFrame());
        frame.setSize(525, 525);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //frame.paint(g); // exception here
    }
}