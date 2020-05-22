import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class TableSelection extends JPanel {

    private final DefaultTableModel model = new DefaultTableModel();
    private final JTable table = new JTable(model);

    public TableSelection() {
        List<String> labels = new ArrayList<>();
        labels.add("");
        for (int i = 1; i < 10 + 1; i++) {
            labels.add("" + (i - 1));
        }
        model.addColumn("Column 1");
        model.addColumn("Column 2");

        JComboBox<String> combo = new JComboBox<>();
        combo.setModel(new DefaultComboBoxModel(labels.toArray()));
        combo.setBackground(Color.WHITE);
        combo.setSelectedIndex(1);
        DefaultCellEditor editor = new DefaultCellEditor(combo);
        table.getColumnModel().getColumn(0).setCellEditor(editor);
        //model.addRow(new JComboBox[]{combo});
        model.addRow(new String[]{labels.get(0)});
        table.setPreferredScrollableViewportSize(new Dimension(320, 120));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(new JScrollPane(table));
        table.setRowSelectionInterval(0, 0);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame("TableSelection");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(new TableSelection());
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}