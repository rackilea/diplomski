import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class MyApplication extends javax.swing.JFrame
{

/** Creates new form MyApplication */
    Image backgroundImage = Toolkit.getDefaultToolkit().getImage("mong.jpg");

    public MyApplication() throws IOException
    {

        this.setContentPane(new JPanel()
        {

            @Override
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, null);
            }
        });

        pack();
        setVisible(true);
    }


    public static void main(String[] args)
        throws Exception
    {
        new MyApplication();
    }
}