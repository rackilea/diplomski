import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TablePropertyEditor extends JFrame
{
    public TablePropertyEditor()
    {
        String[] columnNames = {"Type", "Value"};
        Object[][] data =
        {
            {"String", "I'm a string"},
            {"Date", new Date()},
            {"Integer", new Integer(123)},
            {"Double", new Double(123.45)},
            {"Boolean", Boolean.TRUE}
        };

        JTable table = new JTable(data, columnNames)
        {
            private Class editingClass;

            public TableCellRenderer getCellRenderer(int row, int column)
            {
                editingClass = null;
                int modelColumn = convertColumnIndexToModel(column);

                if (modelColumn == 1)
                {
                    Class rowClass = getModel().getValueAt(row, modelColumn).getClass();
                    return getDefaultRenderer( rowClass );
                }
                else
                    return super.getCellRenderer(row, column);
            }

            public TableCellEditor getCellEditor(int row, int column)
            {
                editingClass = null;
                int modelColumn = convertColumnIndexToModel(column);

                if (modelColumn == 1)
                {
                    editingClass = getModel().getValueAt(row, modelColumn).getClass();
                    return getDefaultEditor( editingClass );
                }
                else
                    return super.getCellEditor(row, column);
            }

            //  This method is also invoked by the editor when the value in the editor
            //  component is saved in the TableModel. The class was saved when the
            //  editor was invoked so the proper class can be created.

            public Class getColumnClass(int column)
            {
                return editingClass != null ? editingClass : super.getColumnClass(column);
            }
        };

        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
    }

    public static void main(String[] args)
    {
        TablePropertyEditor frame = new TablePropertyEditor();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}