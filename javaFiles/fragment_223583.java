import javax.swing.JFrame;
import javax.swing.ImageIcon;

class JFrameTest
{
    public static void main(String _[])
    {
        JFrame jFrame = new JFrame("Hello World!!");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setIconImage(new ImageIcon("c:/home/ravi/creampink.png").getImage());
        jFrame.setSize(400,400);
        jFrame.setVisible(true);
    }
}