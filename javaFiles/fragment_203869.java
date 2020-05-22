import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableEnter extends JPanel
{
    public TableEnter()
    {
        JTable table = new JTable(5, 5);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane( table );
        add( scrollPane );

        Action enterAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JTextField textField = (JTextField)e.getSource();
                JTable table = (JTable)textField.getParent();

                if (table.isEditing())
                    table.getCellEditor().stopCellEditing();

                //  add your custom logic here

                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                System.out.println(row + " : " + column);
            }
        };

        DefaultCellEditor editor = (DefaultCellEditor)table.getDefaultEditor(Object.class);
        JTextField textField = (JTextField)editor.getComponent();

        final String enterKey = "VK_ENTER";
        KeyStroke enter = KeyStroke.getKeyStroke("pressed ENTER");
        textField.getInputMap().put(enter, enterKey);
        textField.getActionMap().put(enterKey, enterAction);
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new TableEnter() );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
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