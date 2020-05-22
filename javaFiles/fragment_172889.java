import java.awt.*;
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import javax.swing.*;

class TransparentFrame extends JFrame
{
    public TransparentFrame()
    {
        JPanel panel = new JPanel();
        panel.setOpaque( false );
        panel.add( new JButton("Button") );
        add(panel, BorderLayout.SOUTH);

        setUndecorated(true);
        setSize(300, 300);
        //pack();
//      setOpacity(0.5f); // set transparency on frame and components
        setBackground( new Color(0, 0, 0, 64) ); // set transparency on frame only

        setTitle("Transparent Frame Demo");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String args[])
    {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        //  Exit when translucent windows aren't supported

        if (!gd.isWindowTranslucencySupported(TRANSLUCENT))
        {
            System.err.println( "Translucency is not supported" );
            System.exit(0);
        }

        // Create the GUI on the event-dispatching thread

        SwingUtilities.invokeLater(() -> new TransparentFrame().setVisible(true));
    }
}