import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Example extends JFrame {

    private JTable table;

    public Example(){
        table = getTable();
        add(new JScrollPane(table));

        pack();
        setVisible(true);
    }

    private JTable getTable() {
        table = new JTable(new DefaultTableModel(3,3){
            @Override
            public void setValueAt(Object aValue, int row, int column) {
                super.setValueAt(aValue, row, column);
                if(column == 2){
                    if(aValue.toString().isEmpty()){
                        removeRow(row);
                    } else {
                        addRow(new Object[] {null, null, null});
                    }
                }
            }
        });
        TableColumn column = table.getColumnModel().getColumn(2);
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"","1","2","3","4","5"});
        column.setCellEditor(new DefaultCellEditor(comboBox));
        return table;
    }

    public static void main(String[] values){
        new Example();
    }

}