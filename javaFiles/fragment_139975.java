import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Demo {

    private void createAndShowGUI() { 

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Column # 1", "Column # 2"}, 0);
        model.addRow(new Object[]{"Property # 1", "Value # 1"});
        model.addRow(new Object[]{"Property # 2", Boolean.TRUE});
        model.addRow(new Object[]{"Property # 3", "Value # 3"});

        JTable table = new JTable(model) {
            @Override
            public TableCellRenderer getCellRenderer(int row, int column) {
                if(getValueAt(row, column) instanceof Boolean) {
                    return super.getDefaultRenderer(Boolean.class);
                } else {
                    return super.getCellRenderer(row, column);
                }
            }

            @Override
            public TableCellEditor getCellEditor(int row, int column) {
                if(getValueAt(row, column) instanceof Boolean) {
                    return super.getDefaultEditor(Boolean.class);
                } else {
                    return super.getCellEditor(row, column);
                }
            }
        };
        table.setAutoCreateRowSorter(true);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(table));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {                
                new Demo().createAndShowGUI();
            }
        });
    }    
}