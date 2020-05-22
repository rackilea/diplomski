import java.awt.event.*;
import javax.swing.*;

public class UpAction extends WrappedAction implements ActionListener
{
    private JTable table;
    private Action endAction;

    /*
     *  Specify the component and KeyStroke for the Action we want to wrap
     */
    public UpAction(JTable table, KeyStroke keyStroke)
    {
        super(table, keyStroke);
        this.table = table;
        endAction = table.getActionMap().get("selectLastRow");
    }

    /*
     *  Provide the custom behaviour of the Action
     */
    public void actionPerformed(ActionEvent e)
    {
        if (table.getSelectedRow() == 0)
            endAction.actionPerformed( e );
        else
            invokeOriginalAction( e );
    }

    private static void createAndShowGUI()
    {
        JTable table = new JTable(7, 5);
        new UpAction(table, KeyStroke.getKeyStroke("UP"));

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new JScrollPane(table) );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}