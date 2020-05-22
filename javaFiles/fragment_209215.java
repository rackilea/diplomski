import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class LocaleEditor extends DefaultCellEditor
{
    private Object value;

    public LocaleEditor()
    {
        super( new JTextField() );
        ((JTextField)getComponent()).setHorizontalAlignment(JTextField.RIGHT);
    }

    @Override
    public Object getCellEditorValue()
    {
        return value;
    }

    @Override
    public boolean stopCellEditing()
    {
        try
        {
            String editingValue = (String)super.getCellEditorValue();

            //  Don't allow user to enter "."

            if (editingValue.contains("."))
            {
                JTextField textField = (JTextField)getComponent();
                textField.setBorder(new LineBorder(Color.red));
                return false;
            }

            // Replace local specific character

            int offset = editingValue.lastIndexOf(",");

            if (offset != -1)
            {
                StringBuilder sb = new StringBuilder(editingValue);
                sb.setCharAt(offset, '.');
                editingValue = sb.toString();
            }

            value = Double.parseDouble( editingValue );
        }
        catch(NumberFormatException exception)
        {
            JTextField textField = (JTextField)getComponent();
            textField.setBorder(new LineBorder(Color.red));
            return false;
        }

        return super.stopCellEditing();
    }

    @Override
    public Component getTableCellEditorComponent(
        JTable table, Object value, boolean isSelected, int row, int column)
    {
        Component c = super.getTableCellEditorComponent(table, value, isSelected, row, column);

        JTextField textField = (JTextField)c;
        textField.setBorder( new LineBorder(Color.BLACK) );

        String text = textField.getText();
        int offset = text.lastIndexOf(".");

        // Display local specific character

        if (offset != -1)
        {
            StringBuilder sb = new StringBuilder(text);
            sb.setCharAt(offset, ',');
            textField.setText( sb.toString() );
        }

        return c;
    }

    private static void createAndShowUI()
    {
        String[] columnNames = {"String", "Double", "Boolean"};

        Object[][] data =
        {
            {"A", new Double(1), Boolean.TRUE },
            {"B", new Double(2.25), Boolean.FALSE},
            {"C", new Double(12.34), Boolean.TRUE },
            {"D", new Double(1234.56), Boolean.FALSE}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
            //  Returning the Class of each column will allow different
            //  renderers and editors to be used based on Class

            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                        return o.getClass();
                }

                return Object.class;
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(20);

        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //  Use a custom renderer and editor

        NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
        nf.setMinimumFractionDigits(2);
        TableCellRenderer renderer = new NumberRenderer( nf );
        table.setDefaultRenderer(Double.class, renderer);
        TableCellEditor fce = new LocaleEditor();
        table.setDefaultEditor(Double.class, fce);

        JFrame frame = new JFrame("Table Five Character Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( scrollPane );
        frame.pack();
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