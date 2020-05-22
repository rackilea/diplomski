import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.UIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TableRolloverDemo {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("TableRolloverDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTable table = new JTable();

        final DefaultTableModel model = new DefaultTableModel(new Object[][] {
                { false }, { false }, { true }, { true } },
                new Object[] { "Column" }) {
            public Class<?> getColumnClass(int columnIndex) {
                return Boolean.class;
            }
        };

        RolloverMouseAdapter rolloverAdapter = new RolloverMouseAdapter(table);
        RolloverBooleanRenderer renderer = new RolloverBooleanRenderer(rolloverAdapter);

        table.addMouseListener(rolloverAdapter);
        table.addMouseMotionListener(rolloverAdapter);

        table.setDefaultRenderer(Boolean.class, renderer);
        table.setModel(model);

        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    static class RolloverMouseAdapter extends MouseAdapter {
        private int row = -1;
        private int column = -1;
        private JTable table;

        public RolloverMouseAdapter(JTable table) {
            this.table = table;
        }

        public boolean isRolloverCell(int row, int column) {
            return this.row == row && this.column == column;
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            int lastRow = row;
            int lastColumn = column;

            row = table.rowAtPoint(e.getPoint());
            column = table.columnAtPoint(e.getPoint());

            if (row == lastRow && column == lastColumn)
                return;

            if (row >= 0 && column >= 0) {
                table.repaint(table.getCellRect(row, column, false));
            }
            if (lastRow >= 0 && lastColumn >= 0) {
                table.repaint(table.getCellRect(lastRow, lastColumn, false));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (row >= 0 && column >= 0) {
                table.repaint(table.getCellRect(row, column, false));
            }
            row = column = -1;
        }

    }

    static class RolloverBooleanRenderer extends JCheckBox implements
            TableCellRenderer, UIResource {
        private static final Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);
        private RolloverMouseAdapter adapter;

        public RolloverBooleanRenderer(RolloverMouseAdapter adapter) {
            super();
            this.adapter = adapter;
            setHorizontalAlignment(JLabel.CENTER);
            setBorderPainted(true);
        }

        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {

            getModel().setRollover(adapter.isRolloverCell(row, column));

            if (isSelected) {
                setForeground(table.getSelectionForeground());
                super.setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
            setSelected((value != null && ((Boolean) value).booleanValue()));

            if (hasFocus) {
                setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
            } else {
                setBorder(noFocusBorder);
            }

            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}