import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.table.*;

public class SSCCE extends JPanel
{
    public SSCCE()
    {
        setLayout( new BorderLayout() );

        JTable table = new JTable(10, 1);
        table.setValueAt("one", 0, 0);
        table.setValueAt("one", 1, 0);
        table.setValueAt("two", 2, 0);
        table.setValueAt("two", 3, 0);
        table.setValueAt("two", 4, 0);
        table.setValueAt("three", 5, 0);
        add( new JScrollPane( table ) );

        table.setDefaultRenderer(Object.class, new DuplicateRenderer());
    }

    /*
    **  Color the focused cell
    */
    class DuplicateRenderer extends DefaultTableCellRenderer
    {
        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (row > 0 && value != null)
            {
                Object previous = table.getValueAt(row - 1, column);

                if (value.equals(previous))
                {
                    setText("");
                }
            }

            return this;
        }
    }


    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.setLocationByPlatform( true );
        frame.pack();
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
}