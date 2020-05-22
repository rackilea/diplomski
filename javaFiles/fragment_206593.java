import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Sprite extends JPanel implements ActionListener{

    private ImageIcon[] sprites = new ImageIcon[4]; 
    private Timer time;
    private int delay = 500, currentFrame = 0; 


    private ImageIcon a0 = new ImageIcon("C:/Users/Guilherme/Desktop/G/FEUP/2º Ano/2nd semester/Eclipse repos/Sprite/src/images/ball.jpg");
    private ImageIcon a1 = new ImageIcon("C:/Users/Guilherme/Desktop/G/FEUP/2º Ano/2nd semester/Eclipse repos/Sprite/src/images/transferir.jpg");
    private ImageIcon a2 = new ImageIcon("C:/Users/Guilherme/Desktop/G/FEUP/2º Ano/2nd semester/Eclipse repos/Sprite/src/images/smurf_sprite.png");


    public Sprite() {

        sprites[0] = a0;
        sprites[1] = a0;
        sprites[2] = a1;
        sprites[3] = a2;

        time = new Timer(delay, this);
        time.start();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        sprites[currentFrame].paintIcon(this, g, 0, 0);

        if (currentFrame == sprites.length-1) {
            time.stop();
        }
        else currentFrame++;
    }

    public void actionPerformed(ActionEvent e) {

        repaint();
    }

    public static void main(String[] arg) {
        JFrame f = new JFrame();
        Sprite s = new Sprite();
        f.add(s);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,400);
    }
}