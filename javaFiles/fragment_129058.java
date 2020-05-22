import javax.swing.*;
import java.awt.event.*;
import java.util.*;
class Listeners extends JFrame
{
    public void prepareAndShowGUI()
    {
        setTitle("Listeners dependency");
        JButton button = new JButton("Click");
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                System.out.println("Action Listener has listened.");
            }
        });
        button.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                System.out.println("Mouse Clicked.");
            }
            public void mousePressed(MouseEvent evt)
            {
                System.out.println("Mouse pressed.");
            }
            public void mouseReleased(MouseEvent evt)
            {
                System.out.println("Mouse Released.");
            }
        });
        getContentPane().add(button);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String stp[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Listeners listen = new Listeners();
                listen.prepareAndShowGUI();
            }
        });
    }
}