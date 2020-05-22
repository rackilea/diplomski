import javax.swing.*;    
import java.awt.*;
import java.util.Random;

public class VirusGamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    Random colour = new Random();
    int score = 0;

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.magenta);
        g.drawString("Score: "+ score,200,200);
        g.setColor(Color.orange);
        g.drawOval(200,150,200,200);
        Color rand = new Color(colour.nextInt(255),colour.nextInt(255),colour.nextInt(255));
        g.setColor(rand);
        g.fillOval(270,50,50,50);
        g.fillOval(100,100,50,50);
        g.fillOval(450,100,50,50);//this line is causing the problem
        g.fillOval(100,400,50,50);
    }

    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setSize(600,600);
        f.add(new VirusGamePanel());
        f.setVisible(true);

    }
}