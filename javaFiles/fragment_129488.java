import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DrawPanel extends JPanel
{
    int i = 0;
    public DrawPanel() {
        ActionListener animate = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }
        };
        Timer timer = new Timer(50,animate);
        timer.start();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(new Color(71,12,3));
        g.fillRect(35,30,410,90);

        Color c = new Color (12*i/2,8*i/2,2*i/2);
        g.setColor(c);
        g.fillRect( 30+10*i,35,20,80);

        i+=2;
        if (i>40) i = 0;
    }
}

class ProgressBar
{
    public static void main (String []args)
    {
        DrawPanel panel = new DrawPanel();
        JFrame app = new JFrame();
        app.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.setSize(500,200);
        app.setVisible(true);
    }
}