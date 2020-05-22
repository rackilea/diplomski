import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AppletBasic extends JApplet
{
    /**
     * Create the GUI. For thread safety, this method should
     * be invoked from the event-dispatching thread.
     */
    private void createGUI()
    {
        JLabel appletLabel = new JLabel( "I'm a Swing Applet" );
        appletLabel.setHorizontalAlignment( JLabel.CENTER );
        appletLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        add( appletLabel );
    }

    public void init()
    {
        try
        {
            SwingUtilities.invokeAndWait(new Runnable()
            {
                public void run()
                {
                    createGUI();
                }
            });
        }
        catch (Exception e)
        {
            System.err.println("createGUI didn't successfully complete: " + e);
        }
    }

    public static void main(String[] args)
    {
        JApplet applet = new AppletBasic();
        applet.init();

        JFrame frame = new JFrame("Applet in Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( applet );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );

        applet.start();
    }
}