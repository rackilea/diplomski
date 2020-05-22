import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.*;

public class InternalFrameUnMovable2 extends JFrame
{
    JDesktopPane desktop;

    public InternalFrameUnMovable2()
    {
        desktop = new JDesktopPane();
        desktop.setDesktopManager( new NoDragDesktopManager() );
        getContentPane().add( desktop );

        desktop.add( createInternalFrame(1, Color.RED) );
        desktop.add( createInternalFrame(2, Color.GREEN) );
        desktop.add( createInternalFrame(3, Color.BLUE) );
    }

    private JInternalFrame createInternalFrame(int number, Color background)
    {
        JInternalFrame internal =
            new JInternalFrame( "Frame" + number, true, true, true, true );
        internal.setBackground( background );
        internal.setVisible( true );
        int location = 50 * number;
        internal.setBounds(location, location, 300, 300);
        return internal;
    }

    public static void main(String args[])
    {
        InternalFrameUnMovable2 frame = new InternalFrameUnMovable2();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.setSize(600, 600);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);

        //  Activate first internal frame

        try
        {
            JInternalFrame[] frames = frame.desktop.getAllFrames();
            frames[0].setSelected(true);
        }
        catch (java.beans.PropertyVetoException e) {}

        //  Make first internal frame unmovable

        JInternalFrame[] frames = frame.desktop.getAllFrames();
        JInternalFrame f = frames[0];
        f.putClientProperty("dragMode", "fixed");
    }

    class NoDragDesktopManager extends DefaultDesktopManager
    {
        public void beginDraggingFrame(JComponent f)
        {
            if (!"fixed".equals(f.getClientProperty("dragMode")))
                super.beginDraggingFrame(f);
        }

        public void dragFrame(JComponent f, int newX, int newY)
        {
            if (!"fixed".equals(f.getClientProperty("dragMode")))
                super.dragFrame(f, newX, newY);
        }

        public void endDraggingFrame(JComponent f)
        {
            if (!"fixed".equals(f.getClientProperty("dragMode")))
                super.endDraggingFrame(f);
        }
    }
}