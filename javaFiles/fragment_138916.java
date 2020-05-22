import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;
import javax.swing.table.AbstractTableModel;
class TableDemo extends JFrame  implements TableModelListener
{
    private JTable table;
    private JScrollPane jsPane;
    private TableModel myModel;
    private JLabel label;
    public void prepareAndShowGUI()
    {
        myModel = new MyModel();
        table = new JTable(myModel);
        jsPane = new JScrollPane(table);
        label = new JLabel();
        myModel.addTableModelListener(this);
        getContentPane().add(jsPane);
        getContentPane().add(label,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    @Override
    public void tableChanged ( TableModelEvent evt)
    {
        int row = evt.getFirstRow();
        int col = evt.getColumn();
        label.setText("Value at ["+row+"]["+col+"] is changed to: "+myModel.getValueAt(row,col));
           //Write to your file here.
    }
    private class MyModel extends AbstractTableModel 
    {
        String[] columns = {
                            "Roll No.",
                            "Name"
                            };
        String[][] inData = {
                                {"1","Anthony Hopkins"},
                                {"2","James William"},
                                {"3","Mc. Donald"}
                            };
        @Override
        public void setValueAt(Object value, int row, int col)
        {
            inData[row][col] = (String)value;
            fireTableCellUpdated(row,col);
        }
        @Override
        public Object getValueAt(int row, int col)
        {
            return inData[row][col];
        }
        @Override
        public int getColumnCount()
        {
            return columns.length;
        }
        @Override 
        public int getRowCount()
        {
            return inData.length;
        }
        @Override
        public String getColumnName(int col)
        {
            return columns[col];
        }
        @Override 
        public boolean isCellEditable(int row, int col)
        {
            return true;
        }
    }
    public static void main(String st[])
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                TableDemo td = new TableDemo();
                td.prepareAndShowGUI();
            }
        });
    }
}