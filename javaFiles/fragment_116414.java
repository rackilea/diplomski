import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
// import redis.clients.jedis.Jedis;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Station1 {
    private static final String IMG_PATH = "https://upload.wikimedia.org/wikipedia/"
            + "commons/thumb/f/f4/LINCOLN%2C_Abraham-President_%28BEP_engraved_portrait%29.jpg"
            + "/800px-LINCOLN%2C_Abraham-President_%28BEP_engraved_portrait%29.jpg";

    public Station1() {
        Gradient gradient = new Gradient();
        JFrame f = new JFrame("Input Carousel");
        f.setLayout(new BorderLayout());

        JLabel label = new JLabel();

        // ImageIcon icon = new ImageIcon(getClass().getResource("images/input carousel.jpg"));

        BufferedImage img = null;
        try {
            URL imgUrl = new URL(IMG_PATH);
            img = ImageIO.read(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Icon icon = new ImageIcon(img);

        label.setIcon(icon);

        gradient.add(label);
        f.add(gradient);

        f.pack();
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Station1();
            }
        });
    }

    @SuppressWarnings("serial")
    class Gradient extends JPanel {
        private JedisMock jedisMock = new JedisMock("localhost");
        private String jedisValue = "";

        public Gradient() {
            int timerDelay = 200;
            new Timer(timerDelay, new TimerListener()).start();
        }

        private class TimerListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // may need to wrap this within a try/catch
                jedisValue = jedisMock.get("b1");
                repaint();
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    0.5f);
            g2D.setComposite(alphaComposite);
            if (jedisValue.equals("1")) {
                g2D.setColor(Color.GREEN);
                g2D.fillRect(208, 172, 47, 75);
            } else if (jedisValue.equals("e")) {
                g2D.setColor(Color.RED);
                g2D.fillRect(208, 172, 47, 75);
            }
        }
    }

}