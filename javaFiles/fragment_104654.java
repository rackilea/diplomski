import java.awt.*;
import javax.swing.*;
import java.applet.*;

public class So1 extends Applet{

    public void paint (Graphics g)
    {
        g.drawString("hello",40,30);
    }

    public static void main(String ad[])
    {

        JFrame jp1 = new JFrame();
        So1 a=new So1 ();
        jp1.getContentPane().add(a, BorderLayout.CENTER);
        jp1.setSize(new Dimension(500,500));
        jp1.setVisible(true);

    }
}