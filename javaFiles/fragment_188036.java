import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Frame1 extends JFrame {
    // Image attribution:
    // By Adam Evans - M31, the Andromeda Galaxy (now with h-alpha)
    // Uploaded by NotFromUtrecht, CC BY 2.0,
    // https://commons.wikimedia.org/w/index.php?curid=12654493
    public static final String ANDROMEDA_IMAGE = "https://upload.wikimedia.org/wikipedia/commons/"
            + "thumb/9/98/Andromeda_Galaxy_%28with_h-alpha%29.jpg/"
            + "1280px-Andromeda_Galaxy_%28with_h-alpha%29.jpg";
    public static final String SPRITE_IMAGE = "https://upload.wikimedia.org/wikipedia/commons/"
            + "thumb/a/a1/Glossy_3d_blue_blue2.png/" + "120px-Glossy_3d_blue_blue2.png";

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final int DELAY = 10;
    private Panel1 panel;
    // private Background bg;

    public Frame1() {
        panel = new Panel1();
        // bg = new Background();
        initComponents();
    }

    public void initComponents() {
        this.setSize(WIDTH, HEIGHT);
        // this.add(bg);
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                    panel.moveLeft();
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                    panel.moveRight();
            }
        });
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame1().setVisible(true);
            }
        });
    }
}