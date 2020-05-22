import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Test extends JFrame{

    public static void main(String [] args){
        new Test();
    }

    private Test(){
        final BufferedImage img = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.createGraphics();
        g.setColor(Color.BLACK);

        int total_width = img.getWidth();
        int y = 30;
        int padding = 100;

        String [] words = new String[]{"Example", "Of", "Right", "Alignment"};
        for(int i = 0; i < words.length; i++){
            int actual_width = g.getFontMetrics().stringWidth(words[i]);
            int x = total_width - actual_width - padding;
            g.drawString(words[i], x, y += 30);
        }
        g.dispose();


        setContentPane(new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });

        setSize(300,300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}