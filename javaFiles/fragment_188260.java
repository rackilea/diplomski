import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SSCCE extends JPanel
{

    SSCCE()
    {
        setLayout( new BorderLayout() );

        JPanel top = new JPanel( new GridLayout(0, 3) );
        top.add( new JTextField(10) );
        top.add( new JButton("Button") );
        top.add( new JTextField(10) );
        add(top, BorderLayout.PAGE_START);

        JPanel center = new JPanel()
        {
            @Override
            public Dimension getPreferredSize()
            {
                Dimension parent = getParent().getSize();

                if (parent.width < parent.height)
                    return new Dimension(parent.width, parent.width);
                else
                    return new Dimension(parent.height, parent.height);

            }
        };
        center.setBackground( Color.BLUE );

        JPanel wrapper = new JPanel( new GridBagLayout() );
        wrapper.add(center, new GridBagConstraints());

        add(wrapper, BorderLayout.CENTER);
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }


static class DragListener extends MouseInputAdapter
{
    Point location;
    MouseEvent pressed;

    public void mousePressed(MouseEvent me)
    {
        pressed = me;
    }

    public void mouseDragged(MouseEvent me)
    {
        Component component = me.getComponent();
        location = component.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();
        component.setLocation(x, y);
     }
}

}