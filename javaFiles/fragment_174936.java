import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Second extends JPanel implements KeyListener
{
    int x = 0, y = 0;
  public Second()
  {
    addKeyListener(this);
    setFocusable(true);
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.fill(new Ellipse2D.Double(x, y, 40, 40));
  }

  public void up()
  {
    if(y >= 5) {
        y -= 5;
        repaint();  
    }    
  }

  public void down()
  { 
    y += 5;
    repaint();
  }

  public void left()
  {   
    if(x >= 5) {
        x -= 5;
        repaint();  
    }
  }

  public void right()
  {   
    x += 5;
    repaint();  
  }

  public void keyPressed(KeyEvent e)
  {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_UP)
    {
      up();
    }
    if (keyCode == KeyEvent.VK_DOWN)
    {
      down();
    }
    if (keyCode == KeyEvent.VK_LEFT)
    {
      left();
    }
    if (keyCode == KeyEvent.VK_RIGHT)
    {
      right();
    }
  }

  public void keyTyped(KeyEvent e)
  {
  }

  public void keyReleased(KeyEvent e)
  {
  }

  public static void main(String args[])
  {
    Second s = new Second();
    JFrame f = new JFrame();
    f.add(s);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(800, 600);
  }
}