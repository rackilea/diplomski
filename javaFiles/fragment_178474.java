import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TablePopupListener extends JPanel
{
    public TablePopupListener()
    {
        JTable table = new JTable(10, 5);
        add( new JScrollPane( table ) );

        JPopupMenu popup = new JPopupMenu();
        popup.add( new JMenuItem("Do Something1") );
        popup.add( new JMenuItem("Do Something2") );

        table.setComponentPopupMenu( popup );

        table.addMouseListener( new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                System.out.println("Pressed JTable");
            }

            public void mouseReleased(MouseEvent e)
            {
                System.out.println("Released JTable");

                int row = table.rowAtPoint( e.getPoint() );

                if (row != -1
                && !table.isRowSelected(row))
                {
                   table.setRowSelectionInterval(row, row);
                }
            }
        });
    }

    private static void createAndShowGUI()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) { System.out.println(ex); }

        JFrame frame = new JFrame("TablePopupListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TablePopupListener());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );

        Toolkit.getDefaultToolkit().addAWTEventListener( new AWTEventListener()
        {
            public void eventDispatched(AWTEvent e)
            {
                String event = null;

                switch (e.getID())
                {
                    case MouseEvent.MOUSE_PRESSED:  event = "Pressed: " ; break;
                    case MouseEvent.MOUSE_RELEASED:  event = "Released: " ; break;
                    case MouseEvent.MOUSE_ENTERED:  event = "Entered: " ; break;
                    case MouseEvent.MOUSE_EXITED:  event = "Exited: " ; break;
                    default: event = null; break;
                }

                if (event != null)
                {
                    System.out.println();
                    System.out.println(event + e.getSource().getClass());
                }
            }
        },  AWTEvent.MOUSE_EVENT_MASK);
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
}