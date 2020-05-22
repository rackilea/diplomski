import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import javax.swing.table.*;

public class ButtonGroupMockupTest {
    private static void createAndShowGUI() {
        DefaultTableModel model = new DefaultTableModel(new Object[][] {
                { "Group 1", Boolean.FALSE }, { "Group 2", Boolean.FALSE },
                { "Group 3", Boolean.FALSE } },
                new Object[] { "Name", "State" }) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int col) {
                if (col == 1)
                    return Boolean.class;
                return super.getColumnClass(col);
            }

            @Override
            public void setValueAt(Object value, int row, int col) {
                super.setValueAt(value, row, col);
                if (col == 1 && value.equals(Boolean.TRUE))
                    deselectValues(row, col);
            }

            private void deselectValues(int selectedRow, int col) {
                for (int row = 0; row < getRowCount(); row++) {
                    if (getValueAt(row, col).equals(Boolean.TRUE)
                            && row != selectedRow) {
                        setValueAt(Boolean.FALSE, row, col);
                        fireTableCellUpdated(row, col);
                    }
                }
            }
        };

        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setDefaultRenderer(Boolean.class, new BooleanRadionRenderer());
        table.setDefaultEditor(Boolean.class, new BooleanRadioEditor());

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JScrollPane(table));

        f.pack();
        f.setLocationByPlatform(true);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    static class BooleanRadionRenderer implements TableCellRenderer, UIResource {
        JRadioButton radioButton;
        Border emptyBorder;

        public BooleanRadionRenderer() {
            radioButton = new JRadioButton();
            radioButton.setHorizontalAlignment(JRadioButton.CENTER);
            radioButton.setBorderPainted(true);
            emptyBorder = BorderFactory.createEmptyBorder(1, 1, 1, 1);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {
            if (isSelected) {
                radioButton.setBackground(table.getSelectionBackground());
                radioButton.setForeground(table.getSelectionForeground());
            } else {
                radioButton.setBackground(table.getBackground());
                radioButton.setForeground(table.getForeground());
            }
            if (hasFocus)
                radioButton.setBorder(UIManager
                        .getBorder("Table.focusCellHighlightBorder"));
            else
                radioButton.setBorder(emptyBorder);

            radioButton.setSelected(((Boolean) value).booleanValue());
            return radioButton;
        }
    }

    static class BooleanRadioEditor extends AbstractCellEditor 
                                    implements TableCellEditor {
        private static final long serialVersionUID = 1L;
        private JRadioButton radioButton;

        public BooleanRadioEditor() {
            radioButton = new JRadioButton();
            radioButton.setHorizontalAlignment(JRadioButton.CENTER);
            radioButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // prevent deselection to mimic button group
                    if (!radioButton.isSelected())
                        cancelCellEditing();
                    stopCellEditing();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int col) {
            radioButton.setSelected(((Boolean) value).booleanValue());
            return radioButton;
        }

        @Override
        public Object getCellEditorValue() {
            return Boolean.valueOf(radioButton.isSelected());
        }
    }   
}