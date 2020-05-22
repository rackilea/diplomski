import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameTest extends JFrame
{
    public FrameTest()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);        

        final JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLUE);
        final JPanel panel2 = new JPanel();
        panel2.setBackground(Color.DARK_GRAY);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu1 = new JMenu("MENU 1");
        JMenu menu2 = new JMenu("MENU 2");
        JMenu menu3 = new JMenu("MENU 3");


        JMenuItem menuItem1 = new JMenuItem("CHANGE PANELS");     
        JMenuItem menuItem2 = new JMenuItem("MENU ITEM 2");
        JMenuItem menuItem3 = new JMenuItem("MENU ITEM 3");
        menuItem1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if (panel1.isShowing())
                {
                    remove(panel1);
                    add(panel2, BorderLayout.CENTER);
                }
                else if (panel2.isShowing())
                {
                    remove(panel2);
                    add(panel1, BorderLayout.CENTER);
                }
                // for getRootPane().revalidate();
                revalidate(); // For JDK 7+
                repaint();
            }
        });

        menu1.add(menuItem1);
        menu2.add(menuItem2);
        menu3.add(menuItem3);

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        JButton button = new JButton("CHANGE");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if (panel1.isShowing())
                {
                    remove(panel1);
                    add(panel2, BorderLayout.CENTER);
                }
                else if (panel2.isShowing())
                {
                    remove(panel2);
                    add(panel1, BorderLayout.CENTER);
                }
                // for getRootPane().revalidate();
                revalidate(); // For JDK 7+
                repaint();
            }
        });

        add(panel1, BorderLayout.CENTER);
        add(button, BorderLayout.PAGE_END);
        setJMenuBar(menuBar);
        setSize(200, 200);
        setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new FrameTest();
            }
        });
    }
}