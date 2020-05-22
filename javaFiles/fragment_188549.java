public class ProjTry extends JFrame
{
    static BufferedImage img;
    static Graphics g;
    static String s;

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img,0,0,this);
    }