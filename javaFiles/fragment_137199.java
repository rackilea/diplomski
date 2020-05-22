import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
class SPanel extends JPanel
{
    public void init()
    {
        this.add(new JButton("Button"));
        this.add(new JLabel("Click"));
        JPanel pan = new JPanel();
        pan.add(new JButton("PanButton"));
        pan.add(new JTextField(29));
        add(pan);
        addListeners(this);
    }
    public void addListeners(Container comp)
    {
        Component[] components = comp.getComponents();
        for (Component component : components)
        {
            if (component instanceof Container)
            {
                Component[] child = ((Container)component).getComponents();
                if (child != null && child.length > 0)
                {
                    addListeners((Container)component);
                }
            }
            component.addMouseListener(new MouseAdapter()
            {
                public void mousePressed(MouseEvent evt)
                {
                    System.out.println(evt.getSource().getClass());
                }
            });
        }
    }
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                SPanel sp = new SPanel();
                sp.init();
                JFrame frame = new JFrame("Frame");
                frame.getContentPane().add(sp);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}