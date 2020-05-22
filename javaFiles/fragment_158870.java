import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultTableModel model = new DefaultTableModel(new String[]{"A"}, 0) {
                    @Override
                    public void setValueAt(Object aValue, int row, int column) {
                        if (column == 0 && (aValue instanceof Boolean)) {
                            boolean pushed = (boolean) aValue;
                            if (pushed) {
                                removeRow(row);
                            }
                        }
                    }
                };
                model.addRow(new Object[]{"-"});
                model.addRow(new Object[]{"-"});
                JTable table = new JTable(model);
                TableColumn column = table.getColumnModel().getColumn(0);
                column.setCellEditor(new TableDeleteButtonEditor());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TableDeleteButtonEditor extends AbstractCellEditor implements TableCellEditor {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        JButton button;
        boolean isPushed;
        JTable partsTypeValueTable;

        public TableDeleteButtonEditor() {
            button = new JButton();
            button.addActionListener(new DeleteButtonListener());
        }

        public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, int row, int column) {
            partsTypeValueTable = table;
            if (isSelected) {
                button.setFont(new Font("Arial", Font.PLAIN, 30));
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setFont(new Font("Arial", Font.PLAIN, 30));
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            button.setText((value == null) ? "" : value.toString());
            isPushed = false;
            return button;
        }

        public Object getCellEditorValue() {
            return isPushed;
        }

        public class DeleteButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                isPushed = true;
                stopCellEditing();
            }
        }
    }
}