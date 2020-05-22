import javax.swing.*;
import java.awt.*;
public class MainClass
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        final int FRAME_WIDTH  = 400;
        final int FRAME_HEIGHT = 400;
        PaintComponent hi = new PaintComponent();
        panel.add(hi);
        frame.add(panel);
        panel.setBorder(BorderFactory.createLineBorder(Color.red));
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}