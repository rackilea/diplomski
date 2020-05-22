import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Sketch extends JComponent
{
    private Vector<JComponent> controls = new Vector<JComponent>();

    public void addControl(JComponent c)
    {
        c.setSize(100, 50);
        int location = controls.size() * 50;
        c.setLocation(location, location);
        controls.add(c);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(int i=controls.size()-1; i>=0; i--)
        {
            JComponent c = controls.get(i);
            Point location = c.getLocation();
            g.translate(location.x, location.y);
            c.paint(g);
            g.translate(-location.x, -location.y);
        }
    }

    private static void createAndShowUI()
    {
        Sketch sketch = new Sketch();
        sketch.addControl( new JButton("button") );
        sketch.addControl( new JTextField(10) );
        sketch.addControl( new JCheckBox("Checkbox") );

        JFrame frame = new JFrame("Sketch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( sketch );
        frame.setSize(400, 400);
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