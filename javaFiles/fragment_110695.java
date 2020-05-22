import java.awt.*;

class myFrame
extends Frame
{
    public void paint(Graphics g)
    {
        try
        {
            for(int i=10;i<=400;i++)
            {
                g.drawOval(100,i+100,50,50);
                repaint();
                Thread.sleep(500);
                Rectangle r = getBounds();
                g.clearRect(r.x, r.y, r.width, r.height);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}

class BallTest
{
    public static void main(String cp[])
    {
        myFrame mf = new myFrame();
        mf.setSize(500,500);
        mf.setVisible(true);
    }
}