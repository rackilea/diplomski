import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class LimitedTableRowFilter {

    public static void main(String[] args) {
        new LimitedTableRowFilter();
    }

    public LimitedTableRowFilter() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                DefaultTableModel model = new DefaultTableModel(new Object[]{"A"}, 0);
                for (int index = 0; index < 100; index++) {
                    model.addRow(new Object[]{index});
                }
                JTable table = new JTable(model);
                MyRowSorter sorter = new MyRowSorter(model);
                MyRowFilter filter = new MyRowFilter(10);

                sorter.setRowFilter(filter);
                table.setRowSorter(sorter);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}