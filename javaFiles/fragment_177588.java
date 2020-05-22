import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class SelectedTableHeader {

    private JFrame frame = new JFrame("Table Demo");
    private JTableHeader header;
    private Object selectedColumn = null;
    private String[] columnNames = {"String", "Integer", "Float", "Double", "Locale & Double", "Boolean"};
    private Object[][] data = {
        {"aaa", new Integer(12), new Float(12.15), new Double(100.05), new Double(12.05), true},
        {"bbb", new Integer(5), new Float(7.154), new Double(6.1555), new Double(417.55), false},
        {"CCC", new Integer(92), new Float(0.1135), new Double(3.1455), new Double(11.05), true},
        {"ddd", new Integer(12), new Float(31.15), new Double(10.05), new Double(23.05), true},
        {"eee", new Integer(5), new Float(5.154), new Double(16.1555), new Double(17.55), false},
        {"fff", new Integer(92), new Float(4.1135), new Double(31.1455), new Double(3.05), true}};
    private TableModel model = new DefaultTableModel(data, columnNames) {

        private static final long serialVersionUID = 1L;

        @Override
        public Class<?> getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    };
    private JTable table = new JTable(model);

    public SelectedTableHeader() {
        header = table.getTableHeader();
        header.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JTableHeader h = (JTableHeader) e.getSource();
                int i = h.columnAtPoint(e.getPoint());
                Object o = h.getColumnModel().getColumn(i).getHeaderValue();
                if (i < 0) {
                    selectedColumn = null;
                    return;
                }
                selectedColumn = o;
                header.getColumnModel().getColumn(i).setHeaderValue("Clicked");
                h.requestFocusInWindow();
            }
        });
        final TableCellRenderer hr = table.getTableHeader().getDefaultRenderer();
        header.setDefaultRenderer(new TableCellRenderer() {

            private JLabel lbl;

            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (selectedColumn == value) {
                    lbl = (JLabel) hr.getTableCellRendererComponent(table, value, true, true, row, column);
                    lbl.setBorder(BorderFactory.createCompoundBorder(lbl.getBorder(), BorderFactory.createLineBorder(Color.red, 1)));
                    lbl.setHorizontalAlignment(SwingConstants.LEFT);
                } else {
                    lbl = (JLabel) hr.getTableCellRendererComponent(table, value, false, false, row, column);
                    lbl.setBorder(BorderFactory.createCompoundBorder(lbl.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
                    lbl.setHorizontalAlignment(SwingConstants.CENTER);
                }
                if (column == 0) {
                    lbl.setForeground(Color.red);
                } else {
                    lbl.setForeground(header.getForeground());
                }
                /*return (value == selectedColumn) ? hr.getTableCellRendererComponent(
                table, value, true, true, row, column) : hr.getTableCellRendererComponent(
                table, value, false, false, row, column);*/
                return lbl;
            }
        });

        table.setRowHeight(20);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scroll = new JScrollPane(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scroll);
        frame.pack();
        frame.setLocation(150, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                SelectedTableHeader selectedTableHeader = new SelectedTableHeader();
            }
        });
    }
}