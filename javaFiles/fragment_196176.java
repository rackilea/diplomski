import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class InternalFrameListenerTest
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
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1, 1));

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menubar.add(menu);
        JMenuItem menuItem = new JMenuItem("Save");
        menu.add(menuItem);
        frame.setJMenuBar(menubar);
        JDesktopPane d = new JDesktopPane();
        Gui gui = new Gui(d, menuItem);

        frame.getContentPane().add(d);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class Gui implements InternalFrameListener, ActionListener
{

    MyInternalFrame frame;
    JMenuItem save;

    public Gui(JDesktopPane desktop, final JMenuItem save)
    {
        frame = new MyInternalFrame("Title");
        this.save = save;
        frame.setVisible(true);
        desktop.add(frame);
        try
        {
            frame.setSelected(true);
        }
        catch (java.beans.PropertyVetoException e)
        {

        }
        frame.addInternalFrameListener(this);
    }

    class MyInternalFrame extends JInternalFrame
    {

        static final int xPosition = 30, yPosition = 30;

        public MyInternalFrame(String title)
        {
            super(title, true, true, true, true);
            setSize(200,100);
            setLocation(50,50);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        frame.addInternalFrameListener(this);
        System.out.println("beingg called");
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent arg0)
    {
        save.setEnabled(true);
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent arg0)
    {
        save.setEnabled(false);
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent arg0)
    {
        save.setEnabled(false);
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent arg0)
    {
        save.setEnabled(false);
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent arg0)
    {
        save.setEnabled(true);
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent arg0)
    {
        save.setEnabled(false);
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent arg0)
    {
        save.setEnabled(true);
    }
}