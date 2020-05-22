import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.net.URL;
import javax.imageio.ImageIO;

public class Intro extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    private Thread thread;
    private BufferedImage bg;
    private String html =
        "<html><body style='color: yellow;'>" +
        "<h1>Game</h1>" +
        "<p>Welcome to the Game!";

    public Intro() {
        super();
        loadImages();
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(40,40,40,40));
        add(new JLabel(html), BorderLayout.NORTH);
        add(new JTextField("..enter name"), BorderLayout.SOUTH);
    }

    private void loadImages() {
        try {
            URL url = new URL("http://pscode.org/media/stromlo2.jpg");
            bg = ImageIO.read(url);
            setPreferredSize(new Dimension(bg.getWidth(), bg.getHeight()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNotify() {
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while(true) {
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(bg, 0, 0, this);
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, new Intro());
    }
}