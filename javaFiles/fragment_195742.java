import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImgFrame extends JFrame {

    private static BufferedImage IMG;
    static{
        try {
            IMG = ImageIO.read(new File("img/Original_Doge_meme.jpg")); //Replace with your image path
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImgFrame(){
        add(new ImgPanel(), BorderLayout.CENTER);
        setSize(500,700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class ImgPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(IMG, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args){
        new ImgFrame();
    }
}