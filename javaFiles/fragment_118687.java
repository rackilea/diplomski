import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ImageShuffle1 extends JPanel {

    private List<BufferedImage> list = new ArrayList<BufferedImage>();
    private List<BufferedImage> shuffled;
    private JLabel label = new JLabel();

    private int width = 50;
    private int height = 100;

    private Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }
    });

    public ImageShuffle1() {

        try {
            list.add(resizeImage(ImageIO.read(new File("resources/1.png"))));
            list.add(resizeImage(ImageIO.read(new File("resources/2.png"))));
            list.add(resizeImage(ImageIO.read(new File("resources/6.png"))));
            list.add(resizeImage(ImageIO.read(new File("resources/Tulips.jpg"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        shuffled = new ArrayList<BufferedImage>(list);
        Collections.shuffle(shuffled);
        timer.start();
    }

    private BufferedImage resizeImage(BufferedImage originalImage) throws IOException {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    private void update() {
        if (shuffled.isEmpty()) {
            shuffled = new ArrayList<BufferedImage>(list);
            Collections.shuffle(shuffled);
        }

        BufferedImage icon = shuffled.remove(0);
        label.setIcon(new ImageIcon(icon));
    }

    private void display() {
        JFrame f = new JFrame("ImageShuffle");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.add(label);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ImageShuffle1().display();
            }
        });
    }
}