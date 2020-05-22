import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @see http://stackoverflow.com/a/37439731/230513
 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CustomModel model = new CustomModel();
        model.setColumnIdentifiers(new String[]{"A", "B"});
        for (int i = 0; i < 16; i++) {
            model.addRow(new String[]{"A:" + i, "B:" + i});
        }
        JTable table = new JTable(model) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(100, getRowHeight() * getRowCount() / 2);
            }
        };
        table.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer(model));
        table.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer(model));
        f.add(new JScrollPane(table));
        JPanel p = new JPanel();
        p.add(new JButton(new UpdateAction("Update A", model, 0)));
        p.add(new JButton(new UpdateAction("Update B", model, 1)));
        p.add(new JButton(new AbstractAction("Clear") {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.clearEdited(0);
                model.clearEdited(1);
            }
        }));
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class CustomModel extends DefaultTableModel {

        private final Map<Integer, Boolean> edited = new HashMap<>();

        public boolean isEdited(int column) {
            return edited.get(column) != null && edited.get(column);
        }

        public void clearEdited(int column) {
            edited.put(column, false);
            fireTableDataChanged();
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public void setValueAt(Object aValue, int row, int column) {
            super.setValueAt(aValue, row, column);
            edited.put(column, true);
        }
    }

    private static class CustomRenderer extends DefaultTableCellRenderer {

        private final CustomModel model;

        public CustomRenderer(CustomModel model) {
            this.model = model;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {
            Component c = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, col);
            if (model.isEdited(table.convertColumnIndexToModel(col))) {
                c.setBackground(Color.cyan);
            } else if (isSelected) {
                c.setBackground(table.getSelectionBackground());
            } else {
                c.setBackground(table.getBackground());
            }
            return c;
        }
    }

    private static class UpdateAction extends AbstractAction {

        private final CustomModel model;
        private final int column;

        public UpdateAction(String name, CustomModel model, int column) {
            super(name);
            this.model = model;
            this.column = column;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(model.getValueAt(i, column), i, column);
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}