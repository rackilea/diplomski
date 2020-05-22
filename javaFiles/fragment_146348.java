import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameExample
{   
    private JFrame frame;
    private JButton button;
    private JTextField tfield;
    private String nameTField;
    private int count;

    public JFrameExample()
    {
        nameTField = "tField";
        count = 0;
    }

    private void displayGUI()
    {
        frame = new JFrame("JFrame Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1, 2, 2));
        button = new JButton("Add JTextField");
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                tfield = new JTextField();
                tfield.setName(nameTField + count);
                count++;
                frame.add(tfield);
                frame.revalidate();  // For JDK 1.7 or above.
                //frame.getContentPane().revalidate(); // For JDK 1.6 or below.
                frame.repaint();
            }
        });
        frame.add(button);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new JFrameExample().displayGUI();
            }
        });
    }
}