import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiApp extends JFrame
{

private DrawingPanel panel;
public class DrawingPanel extends JPanel 
{
    public DrawingPanel()
    {
        this.setBackground(Color.BLUE);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); 
        drawFlower(g, 20, 10, 10);
    }
}
public void drawFlower(Graphics g,int x,int y,int s)
{
    g.setColor(Color.PINK); 
    g.fillOval(x, y, s, s);
    g.fillOval(x-s, y-s, s, s);
    g.fillOval(x, y-s, s, s);  
    g.fillOval(x-s, y, s, s);     
    g.setColor(Color.YELLOW); 
    g.fillOval(x-s/2, y-s/2, s, s);     
}
public GuiApp()
{
    setBounds(100, 100, 450, 300);//x,y,w,h of window
    panel = new DrawingPanel();
    this.setContentPane(panel);
}
public static void main(String [] args)
{
    GuiApp f = new GuiApp();
    f.setTitle("Smiley");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
}

}