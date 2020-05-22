import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @see http://stackoverflow.com/a/12301173/909085
 */

public class LafIcon implements Icon
{
    private Map<String, Icon> lafIcons;

    public LafIcon ()
    {
        super ();
        lafIcons = new HashMap<String, Icon> ();
    }

    public void addIcon ( String laf, Icon icon )
    {
        lafIcons.put ( laf, icon );
    }

    private String getLaf ()
    {
        return UIManager.getLookAndFeel ().getClass ().getCanonicalName ();
    }

    private Icon getCurrentIcon ()
    {
        return lafIcons.get ( getLaf () );
    }

    public void paintIcon ( Component c, Graphics g, int x, int y )
    {
        Icon icon = getCurrentIcon ();
        if ( icon != null )
        {
            icon.paintIcon ( c, g, x, y );
        }
    }

    public int getIconWidth ()
    {
        Icon icon = getCurrentIcon ();
        return icon != null ? icon.getIconWidth () : 0;
    }

    public int getIconHeight ()
    {
        Icon icon = getCurrentIcon ();
        return icon != null ? icon.getIconHeight () : 0;
    }

    public static void main ( String[] args )
    {
        installMetalLookAndFeel ();

        JFrame frame = new JFrame ();
        frame.setLayout ( new FlowLayout ( FlowLayout.CENTER, 5, 5 ) );

        frame.add ( new JButton ( "Test button", createIcon () ) );

        String[] laf = { "Metal Look and Feel", "Nimbus Look and Feel" };
        final JComboBox lafType = new JComboBox ( laf );
        lafType.addActionListener ( new ActionListener ()
        {
            public void actionPerformed ( ActionEvent e )
            {
                if ( lafType.getSelectedIndex () == 0 )
                {
                    installMetalLookAndFeel ();
                }
                else
                {
                    installNimbusLookAndFeel ();
                }
            }
        } );
        frame.add ( lafType );

        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        frame.pack ();
        frame.setLocationRelativeTo ( null );
        frame.setVisible ( true );
    }

    private static LafIcon createIcon ()
    {
        LafIcon icon = new LafIcon ();    
        try
        {
            icon.addIcon ( MetalLookAndFeel.class.getCanonicalName (), new ImageIcon (
                    new URL ("http://cdn3.iconfinder.com/data/icons/fatcow/32x32_0020/application_form.png") ) );
            icon.addIcon ( NimbusLookAndFeel.class.getCanonicalName (), new ImageIcon (
                    new URL ("http://cdn3.iconfinder.com/data/icons/fatcow/32x32_0040/application_view_gallery.png") ) );
        }
        catch ( MalformedURLException e )
        {
            e.printStackTrace ();
        }    
        return icon;
    }

    private static void installMetalLookAndFeel ()
    {
        installLookAndFeel ( MetalLookAndFeel.class.getCanonicalName () );
    }

    private static void installNimbusLookAndFeel ()
    {
        installLookAndFeel ( NimbusLookAndFeel.class.getCanonicalName () );
    }

    private static void installLookAndFeel ( String name )
    {
        try
        {
            UIManager.setLookAndFeel ( name );

            Window[] windows = Window.getWindows ();
            if ( windows.length > 0 )
            {
                for ( Window window : windows )
                {
                    SwingUtilities.updateComponentTreeUI ( window );
                    window.pack ();
                }
            }
        }
        catch ( ClassNotFoundException e )
        {
            e.printStackTrace ();
        }
        catch ( InstantiationException e )
        {
            e.printStackTrace ();
        }
        catch ( IllegalAccessException e )
        {
            e.printStackTrace ();
        }
        catch ( UnsupportedLookAndFeelException e )
        {
            e.printStackTrace ();
        }
    }
}