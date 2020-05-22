import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class LoginPage3 extends JPanel {
    public static final String BG_IMG_PATH = "https://upload.wikimedia.org/wikipedia/"
            + "commons/e/e9/Maesil_%28prunus_mume%29_washed_and_stemmed.jpg";
    public static final String RU_IMG_PATH = "https://upload.wikimedia.org/wikipedia/"
            + "commons/thumb/5/5b/Escudo_de_San_Pedro_de_Atacama.svg/200px-Escudo_de_San_Pedro_de_Atacama.svg.png";

    private BufferedImage backgroundImg;
    private BufferedImage rightUpperImg;

    public LoginPage3(BufferedImage bgImg, BufferedImage ruImg) {
        this.backgroundImg = bgImg;
        this.rightUpperImg = ruImg;
    }

    @Override
    public Dimension getPreferredSize() {
        if (backgroundImg == null || isPreferredSizeSet()) {
            return super.getPreferredSize();
        } else {
            int w = backgroundImg.getWidth();
            int h = backgroundImg.getHeight();
            return new Dimension(w, h);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImg != null) {
            g.drawImage(backgroundImg, 0, 0, this);
        }
        if (rightUpperImg != null) {
            int x = getWidth() - rightUpperImg.getWidth();
            g.drawImage(rightUpperImg, x, 0, this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        BufferedImage bg = null;
        BufferedImage ru = null;
        try {
            bg = ImageIO.read(new URL(BG_IMG_PATH));
            ru = ImageIO.read(new URL(RU_IMG_PATH));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        LoginPage3 mainPanel = new LoginPage3(bg, ru);
        JFrame frame = new JFrame("LoginPage3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}