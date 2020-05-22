import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DisplayExample extends JComponent {

    private BufferedImage backgroundImage;
    private String backgroundName;

    private BufferedImage image;  //image to draw
    private int imageX;  //position of left edge of image
    private int imageY;  //position of top edge of image

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DisplayExample example = new DisplayExample();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(example);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public DisplayExample() {
        imageX = 200;
        imageY = 200;

        try {
            backgroundImage = ImageIO.read(new File("..."));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        //load image

        try {
            image = ImageIO.read(new File("..."));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //need for keyboard input
        //setFocusable(true);  //indicates that WorldDisp can process key presses
        // Use the key bindings API instead, causes less issues
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageY += 1;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return backgroundImage == null ?  new Dimension(200, 200) : new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        if (backgroundImage != null) {
            // Scaling is expensive, don't do it here
            int x = (getWidth() - backgroundImage.getWidth()) / 2;
            int y = (getHeight() - backgroundImage.getHeight()) / 2;
            g2d.drawImage(backgroundImage, x, y, this);
        }
        g2d.drawImage(image, imageX, imageY, this);
        g2d.dispose();
    }
}