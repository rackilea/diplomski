import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class ShowImage
{
    public static void main(String[] args)
    {
        showImage("C:/image.png");
    }

    private static void showImage(final String fileName)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.getContentPane().setLayout(new GridLayout(1,1));
                f.getContentPane().add(new JLabel(new ImageIcon(fileName)));
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}