import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TransparentImageFrame
{
    private static void createAndShowUI()
    {
        JLabel label = new JLabel( new ImageIcon("...") );
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {
                    System.exit(0);
                }
            }
        });

        JFrame frame = new JFrame("Image Frame");
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add( label );
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}