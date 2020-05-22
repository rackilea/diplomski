import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class oval extends Applet implements KeyListener
{
    private int d=10;

    @Override
    public void init() 
    {
        setSize(500,500);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);
        g.drawOval(100, 100, d, d);
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode()==KeyEvent.VK_L)
            d=d+5;    
        else if(e.getKeyCode()==KeyEvent.VK_S)
            d=d-5;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {

    }
}