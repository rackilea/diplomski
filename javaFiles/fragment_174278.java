package stackoverflow;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class MouseWheelListenerForPanelInScrollpane
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.getContentPane().setLayout(new GridLayout(1,2));

        MouseWheelListenerPanel m = new MouseWheelListenerPanel();
        m.setPreferredSize(new Dimension(100,4000));
        JScrollPane scrollPane = new JScrollPane(m);
        f.getContentPane().add(scrollPane);

        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class MouseWheelListenerPanel extends JPanel implements MouseWheelListener
{
    MouseWheelListenerPanel()
    {
        addMouseWheelListener(this);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        if (e.isControlDown())
        {
            if (e.getWheelRotation() < 0)
            {
                System.out.println("mouse wheel Up");
            }
            else
            {
                System.out.println("mouse wheel Down");
            }
        }
        else
        {
            getParent().dispatchEvent(e);
        }

    }
}