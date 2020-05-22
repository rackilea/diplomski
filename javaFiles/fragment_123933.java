import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StackoverflowStuff {

    public static void main(String[] args) {
        Vector<Vector> data = new Vector<>();
        Vector<String> columnNames = new Vector<>();

        final int rows = 10;
        final int columns = 4;
        for (int i = 0; i < columns; i++) {
            columnNames.add("Col");
        }

        for (int i = 0; i < rows; i++) {
            Vector row = new Vector();
            for (int j = 0; j < columns; j++) {
                row.add(j);
            }
            data.add(row);
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }  
}