import javax.swing.*;
import javax.swing.plaf.metal.*;
import java.awt.*;
import java.awt.image.*;

public class ButtonDisabledIcon extends JPanel
{
    public ButtonDisabledIcon()
    {
        ImageIcon original = new ImageIcon( "dukewavered.gif" );

        JButton button1 = new JButton( "Original" );
        button1.setIcon( original );
        add(button1);

        JButton button2 = new JButton( "Disabled" );
        button2.setIcon(original);
        button2.setEnabled(false);
        add(button2);

        JButton button3 = new JButton( "LAF Disabled" );
        button3.setIcon( UIManager.getLookAndFeel().getDisabledIcon(null, original) );
        add(button3);
  }
    private static void createAndShowUI()
    {
/*
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) { }
*/
        JFrame frame = new JFrame("Button Disabled Icon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new ButtonDisabledIcon() );
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
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